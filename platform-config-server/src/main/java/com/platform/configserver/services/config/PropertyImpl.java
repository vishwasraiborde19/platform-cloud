package com.platform.configserver.services.config;

import com.platform.configserver.dto.AdminDtos.ApplicationSummary;
import com.platform.configserver.dto.AdminDtos.PropertyRequest;
import com.platform.configserver.entities.Property;
import com.platform.configserver.entities.RefreshTarget;
import com.platform.configserver.repositories.PropertyRepo;
import com.platform.configserver.repositories.RefreshTargetRepo;
import com.platform.configserver.services.hotreload.HotReloadService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PropertyImpl implements PropertyService {

    private static final Comparator<Property> ORDER = Comparator
            .comparing((Property p) -> Objects.toString(p.getProfile(), ""))
            .thenComparing(p -> Objects.toString(p.getLabel(), ""))
            .thenComparing(p -> Objects.toString(p.getPropertyKey(), ""));

    private final PropertyRepo propertyRepo;
    private final RefreshTargetRepo refreshTargetRepo;
    private final HotReloadService hotReloadService;

    PropertyImpl(PropertyRepo propertyRepo, RefreshTargetRepo refreshTargetRepo,
                 HotReloadService hotReloadService) {
        this.propertyRepo = propertyRepo;
        this.refreshTargetRepo = refreshTargetRepo;
        this.hotReloadService = hotReloadService;
    }

    @Override
    public List<Property> getAll() {
        return propertyRepo.findAll();
    }

    @Override
    public List<Property> find(String application, String profile, String label) {
        List<Property> source = isBlank(application) ? propertyRepo.findAll() : propertyRepo.findByApplication(application);
        return source.stream()
                .filter(p -> isBlank(profile) || profile.equals(p.getProfile()))
                .filter(p -> isBlank(label) || label.equals(p.getLabel()))
                .sorted(ORDER)
                .toList();
    }

    @Override
    public List<ApplicationSummary> applications() {
        Map<String, List<Property>> byApp = propertyRepo.findAll().stream()
                .filter(p -> p.getApplication() != null)
                .collect(Collectors.groupingBy(Property::getApplication, TreeMap::new, Collectors.toList()));
        Map<String, Long> targetsByApp = refreshTargetRepo.findAll().stream()
                .collect(Collectors.groupingBy(RefreshTarget::getApplication, Collectors.counting()));

        // Applications that only have refresh targets (no properties yet) are listed too.
        targetsByApp.keySet().forEach(app -> byApp.putIfAbsent(app, List.of()));

        return byApp.entrySet().stream()
                .map(e -> new ApplicationSummary(
                        e.getKey(),
                        e.getValue().size(),
                        distinct(e.getValue().stream().map(Property::getProfile)),
                        distinct(e.getValue().stream().map(Property::getLabel)),
                        targetsByApp.getOrDefault(e.getKey(), 0L)))
                .sorted(Comparator.comparing(ApplicationSummary::application, String.CASE_INSENSITIVE_ORDER))
                .toList();
    }

    @Override
    public Property create(PropertyRequest request) {
        Property property = new Property();
        apply(property, request);
        ensureUnique(property);
        Property saved = propertyRepo.save(property);
        hotReloadService.onPropertiesChanged(saved.getApplication(), saved.getProfile());
        return saved;
    }

    @Override
    public Property update(Long id, PropertyRequest request) {
        Property property = getById(id);
        String oldApp = property.getApplication();
        String oldProfile = property.getProfile();
        apply(property, request);
        ensureUnique(property);
        Property saved = propertyRepo.save(property);
        hotReloadService.onPropertiesChanged(saved.getApplication(), saved.getProfile());
        if (!Objects.equals(oldApp, saved.getApplication()) || !Objects.equals(oldProfile, saved.getProfile())) {
            hotReloadService.onPropertiesChanged(oldApp, oldProfile);
        }
        return saved;
    }

    @Override
    public void delete(Long id) {
        Property property = getById(id);
        propertyRepo.delete(property);
        hotReloadService.onPropertiesChanged(property.getApplication(), property.getProfile());
    }

    @Override
    public Property getById(Long id) {
        return propertyRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Property " + id + " not found"));
    }

    private void apply(Property property, PropertyRequest request) {
        if (request == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body is required");
        }
        property.setApplication(required(request.application(), "Application"));
        property.setProfile(required(request.profile(), "Profile"));
        property.setLabel(required(request.label(), "Label"));
        property.setPropertyKey(required(request.propertyKey(), "Key"));
        property.setValue(request.value() == null ? "" : request.value());
    }

    private void ensureUnique(Property candidate) {
        boolean duplicate = propertyRepo.findByApplication(candidate.getApplication()).stream()
                .filter(p -> !Objects.equals(p.getId(), candidate.getId()))
                .anyMatch(p -> Objects.equals(p.getProfile(), candidate.getProfile())
                        && Objects.equals(p.getLabel(), candidate.getLabel())
                        && Objects.equals(p.getPropertyKey(), candidate.getPropertyKey()));
        if (duplicate) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format(
                    "'%s' already exists for %s/%s/%s", candidate.getPropertyKey(),
                    candidate.getApplication(), candidate.getProfile(), candidate.getLabel()));
        }
    }

    static String required(String value, String field) {
        if (isBlank(value)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, field + " is required");
        }
        return value.trim();
    }

    static boolean isBlank(String value) {
        return value == null || value.isBlank();
    }

    private static List<String> distinct(java.util.stream.Stream<String> values) {
        return values.filter(Objects::nonNull).distinct().sorted().toList();
    }
}

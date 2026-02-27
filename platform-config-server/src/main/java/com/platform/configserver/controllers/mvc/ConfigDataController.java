package com.platform.configserver.controllers.mvc;

import com.platform.configserver.entities.Property;
import com.platform.configserver.services.config.PropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/properties")
public class ConfigDataController {

    private final PropertyService propertyService;

    ConfigDataController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }


    // Modern UI view
    @GetMapping("/ui")
    public String modernUI(Model model) {
        model.addAttribute("propertyList", propertyService.getAll());
        return "property_modern";
    }

    // Update redirects to modern with an edit query param so the modern UI opens the modal
    @GetMapping("/update/{id}")
    public String editProperty(@PathVariable("id") Long id, Model model) {
        return "redirect:/properties/ui?edit=" + id;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("property") Property property,
                       Model model) {
        propertyService.addProperty(property);
        // Always return to modern UI since other UI components are removed
        return "redirect:/properties/ui";
    }

    @GetMapping("/delete/{id}")
    public String deleteProperty(@PathVariable(value = "id") long id) {
        propertyService.delete(id);
        return "redirect:/properties/ui";
    }
}

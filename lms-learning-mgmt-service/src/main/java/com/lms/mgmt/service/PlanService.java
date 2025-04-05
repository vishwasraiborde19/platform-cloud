package com.lms.mgmt.service;


import com.lms.mgmt.dto.PlanDTO;
import com.lms.mgmt.entity.Plan;
import com.lms.mgmt.mapper.GenericModelMapper;
import com.lms.mgmt.repository.PlanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PlanService {

    private final PlanRepository planRepository;
    private final GenericModelMapper modelMapper;

    public PlanService(PlanRepository planRepository, GenericModelMapper modelMapper) {
        this.planRepository = planRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<PlanDTO> getPlanById(Integer id) {
        Optional<Plan> Plan = planRepository.findById(id);
        if (Plan.isPresent()) {
            PlanDTO PlanDTO = modelMapper.map(Plan.get(), PlanDTO.class);
            return Optional.of(PlanDTO);
        }
        return Optional.empty();
    }

    public List<PlanDTO> getPlans() {
        List<Plan> Plans = planRepository.findAll();
        List<PlanDTO> PlanDto = modelMapper.map(Plans, List.class);
        return PlanDto;
    }

    public PlanDTO savePlan(PlanDTO PlanDTO) {
        Plan Plan = modelMapper.map(PlanDTO, Plan.class);
        Plan = planRepository.save(Plan);
        PlanDTO = modelMapper.map(Plan, PlanDTO.class);
        return PlanDTO;
    }

    public void deletePlan(Integer id) {
        Plan plan = new Plan();
        plan.setPlanId(id);
        planRepository.delete(plan);
    }

}

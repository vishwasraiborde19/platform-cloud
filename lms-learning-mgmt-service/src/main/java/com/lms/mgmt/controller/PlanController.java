package com.lms.mgmt.controller;


import com.lms.mgmt.dto.PlanDTO;
import com.lms.mgmt.service.PlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Plan-mgmt/v1")
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping("/plans")
    public List<PlanDTO> getPlans() {
        return planService.getPlans();
    }

    @GetMapping("/plans/{id}")
    public PlanDTO getPlan(@RequestParam Integer id) {
        return planService.getPlanById(id).orElse(new PlanDTO());
    }

    @PostMapping("/plans")
    public PlanDTO addPlan(@RequestBody PlanDTO PlanDTO) {
        return planService.savePlan(PlanDTO);
    }

    @DeleteMapping("/plans/{id}")
    public void addPlan(@RequestParam Integer id) {
        planService.deletePlan(id);
    }


}

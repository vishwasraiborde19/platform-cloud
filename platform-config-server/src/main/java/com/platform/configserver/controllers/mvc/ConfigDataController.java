package com.platform.configserver.controllers.mvc;

import com.platform.configserver.services.config.PropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/properties")
public class ConfigDataController {

    private final PropertyService propertyService;

    ConfigDataController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping("/view")
    public String viewProperties(Model model) {
        model.addAttribute("propertyList",propertyService.getAll());
        return "property";
    }

    @PostMapping("/add")
    public String addConfigData(Model model) {
        model.addAttribute("propertyList",propertyService.getAll());
        return "addproperty";
    }
}

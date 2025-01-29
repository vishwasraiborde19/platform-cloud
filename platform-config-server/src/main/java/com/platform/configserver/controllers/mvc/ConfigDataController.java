package com.platform.configserver.controllers.mvc;

import com.platform.configserver.entities.Property;
import com.platform.configserver.services.config.PropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping(value = "/properties")
public class ConfigDataController {

    private final PropertyService propertyService;

    ConfigDataController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/view")
    public String viewProperties(Model model) {
        model.addAttribute("propertyList",propertyService.getAll());
        return "property";
    }

    @GetMapping("/add")
    public String addConfigData(Model model) {
        model.addAttribute("property",new Property());
        return "addproperty";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("property") Property  property) {
        propertyService.addProperty(property);
        return "property";
    }
}

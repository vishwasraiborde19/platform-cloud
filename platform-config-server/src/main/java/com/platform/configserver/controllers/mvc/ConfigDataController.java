package com.platform.configserver.controllers.mvc;

import com.platform.configserver.entities.Property;
import com.platform.configserver.services.config.PropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("property", new Property());
        model.addAttribute("propertyList", propertyService.getAll());
        return "addproperty";
    }

    @GetMapping("/add")
    public String addConfigData(Model model) {
        model.addAttribute("property", new Property());
        model.addAttribute("propertyList", propertyService.getAll());
        return "addproperty";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("property") Property property, Model model) {
        propertyService.addProperty(property);
        model.addAttribute("propertyList", propertyService.getAll());
        return "addproperty";
    }

    @GetMapping("/delete/{id}")
    public String save(@PathVariable(value = "id") long id,
                       Model model) {
        propertyService.delete(id);
        model.addAttribute("property", new Property());
        model.addAttribute("propertyList", propertyService.getAll());
        return "redirect:/properties/add";
    }
}

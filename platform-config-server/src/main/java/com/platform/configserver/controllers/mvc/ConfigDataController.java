package com.platform.configserver.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Entry points for the admin UI. The UI itself is a static page under /admin/ backed by /admin/api.
 */
@Controller
public class ConfigDataController {

    @GetMapping({"/admin", "/admin/", "/properties/ui"})
    public String adminUi() {
        return "forward:/admin/index.html";
    }
}

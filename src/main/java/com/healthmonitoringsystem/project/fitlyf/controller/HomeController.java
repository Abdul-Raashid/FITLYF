package com.healthmonitoringsystem.project.fitlyf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "forward:/index.html";  // ✅ Serves index.html from /static
    }
}


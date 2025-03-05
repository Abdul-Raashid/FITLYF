package com.healthmonitoringsystem.project.fitlyf.controller;

import com.healthmonitoringsystem.project.fitlyf.dto.HealthDetailsDTO;
import com.healthmonitoringsystem.project.fitlyf.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HealthController {

    @Autowired
    private HealthService healthService;

    @GetMapping("/health-details")
    public String healthDetailsForm() {
        return "health-details"; // Load the form page
    }

    @PostMapping("/calculate")
    public String calculateHealth(@ModelAttribute HealthDetailsDTO healthDetails, Model model) {
        // Fetch input values
        double weight = healthDetails.getWeight();
        double height = healthDetails.getHeight();
        String bp = healthDetails.getBp();
        int sugar = healthDetails.getSugar();
        int exercise = healthDetails.getExercise();

        // Calculate results
        double bmi = healthService.calculateBMI(weight, height);
        String bmiStatus = healthService.getBMIStatus(bmi);
        String bpStatus = healthService.evaluateBP(bp);
        String sugarStatus = healthService.evaluateSugar(sugar);
        String dietPlan = healthService.suggestDiet(bmi, bpStatus, sugarStatus, exercise);

        // Pass data to the model
        model.addAttribute("bmi", bmi);
        model.addAttribute("bmiStatus", bmiStatus);
        model.addAttribute("bp", bp);
        model.addAttribute("bpStatus", bpStatus);
        model.addAttribute("sugar", sugar);
        model.addAttribute("sugarStatus", sugarStatus);
        model.addAttribute("dietPlan", dietPlan);

        return "result"; // Load result.html
    }
}

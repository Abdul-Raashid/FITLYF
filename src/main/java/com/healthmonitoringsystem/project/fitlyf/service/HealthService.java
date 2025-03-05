package com.healthmonitoringsystem.project.fitlyf.service;
import org.springframework.stereotype.Service;

@Service
public class HealthService {

    // BMI Calculation Method
    public double calculateBMI(double weight, double heightInFeet) {
        // Convert height from feet to meters
        double heightInMeters = heightInFeet * 0.3048; 
        if (heightInMeters <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0");
        }
        return weight / (heightInMeters * heightInMeters);
    }
    

    // Get BMI Status
    public String getBMIStatus(double bmi) {
        if (bmi < 18.5) return "Underweight - Increase healthy fats and proteins";
        if (bmi >= 18.5 && bmi <= 24.9) return "Normal - Maintain balanced diet";
        if (bmi >= 25 && bmi <= 29.9) return "Overweight - Exercise and eat more fiber";
        return "Obese - Consult a doctor for a weight loss plan";
    }

    // Evaluate Blood Pressure
    public String evaluateBP(String bp) {
        if (bp == null || !bp.contains("/")) {
            return "Invalid BP Format"; // Handle missing or incorrect BP format
        }

        String[] bpValues = bp.split("/");
        if (bpValues.length < 2) {
            return "Invalid BP Data";
        }

        try {
            int systolic = Integer.parseInt(bpValues[0].trim());
            int diastolic = Integer.parseInt(bpValues[1].trim());

            if (systolic < 90 || diastolic < 60) {
                return "Low Blood Pressure - Increase salt and fluid intake.";
            } else if (systolic > 140 || diastolic > 90) {
                return "High Blood Pressure - Reduce salt, monitor regularly.";
            } else {
                return "Normal Blood Pressure";
            }
        } catch (NumberFormatException e) {
            return "Invalid BP Values"; 
        }
    }

    // Evaluate Sugar Level
    public String evaluateSugar(int sugar) {
        if (sugar < 70) return "Low Sugar - Consume sugar immediately!";
        if (sugar >= 70 && sugar <= 99) return "Normal Sugar Level";
        if (sugar >= 100 && sugar <= 125) return "Prediabetes - Reduce sugar intake";
        return "High Sugar - Consult a doctor & avoid sweets!";
    }

    // Generate Diet Plan
    public String suggestDiet(double bmi, String bpStatus, String sugarStatus, int exercise) {
        StringBuilder dietPlan = new StringBuilder();

        dietPlan.append("**Morning:** ");
        if (bmi < 18.5) {
            dietPlan.append("Oatmeal with nuts and fruits, scrambled eggs, a glass of milk. ");
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            dietPlan.append("Whole grain toast with avocado, a boiled egg, and green tea. ");
        } else {
            dietPlan.append("Vegetable smoothie, egg whites, and a handful of almonds. ");
        }

        dietPlan.append("\n**Afternoon (Lunch):** ");
        if (bmi < 18.5) {
            dietPlan.append("Brown rice with grilled chicken, steamed veggies, and yogurt. ");
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            dietPlan.append("Quinoa salad with grilled fish and olive oil dressing. ");
        } else {
            dietPlan.append("Grilled tofu with sautéed spinach and whole wheat chapati. ");
        }

        dietPlan.append("\n**Evening Snack:** ");
        if (bmi < 18.5) {
            dietPlan.append("Protein smoothie or banana with peanut butter. ");
        } else {
            dietPlan.append("A handful of walnuts or roasted chickpeas. ");
        }

        dietPlan.append("\n**Night (Dinner):** ");
        if (bmi < 18.5) {
            dietPlan.append("Baked salmon with mashed sweet potatoes and steamed broccoli. ");
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            dietPlan.append("Grilled paneer with mixed vegetable stir-fry. ");
        } else {
            dietPlan.append("Lentil soup with a fresh salad and a small portion of brown rice. ");
        }

        // Adjustments based on BP
        if (bpStatus.contains("High")) {
            dietPlan.append("\n\n**BP Advice:** Reduce salt intake, eat potassium-rich foods like bananas and spinach.");
        } else if (bpStatus.contains("Low")) {
            dietPlan.append("\n\n**BP Advice:** Increase sodium intake slightly and stay hydrated.");
        }

        // Adjustments based on Sugar Level
        if (sugarStatus.contains("High")) {
            dietPlan.append("\n\n**Sugar Advice:** Avoid processed sugars, consume whole grains and fiber-rich foods.");
        } else if (sugarStatus.contains("Low")) {
            dietPlan.append("\n\n**Sugar Advice:** Eat small, frequent meals to maintain blood sugar levels.");
        }

        return dietPlan.toString();
    }

}

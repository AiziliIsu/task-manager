package com.example.taskmanager.controller;

import com.example.taskmanager.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
public class MathController {

    @Autowired
    private MathService mathService;

    // Add two numbers
    @GetMapping("/add")
    public double add(@RequestParam double a, @RequestParam double b) {
        return mathService.add(a, b);
    }

    // Subtract b from a
    @GetMapping("/subtract")
    public double subtract(@RequestParam double a, @RequestParam double b) {
        return mathService.subtract(a, b);
    }

    // Multiply two numbers
    @GetMapping("/multiply")
    public double multiply(@RequestParam double a, @RequestParam double b) {
        return mathService.multiply(a, b);
    }

    // Divide a by b
    @GetMapping("/divide")
    public double divide(@RequestParam double a, @RequestParam double b) {
        return mathService.divide(a, b);
    }

    // Square root of a number
    @GetMapping("/squareRoot")
    public double squareRoot(@RequestParam double a) {
        return mathService.squareRoot(a);
    }

    // Power of a raised to the b
    @GetMapping("/power")
    public double power(@RequestParam double a, @RequestParam double b) {
        return mathService.power(a, b);
    }

    // Modulus of a by b
    @GetMapping("/modulus")
    public double modulus(@RequestParam double a, @RequestParam double b) {
        return mathService.modulus(a, b);
    }
}

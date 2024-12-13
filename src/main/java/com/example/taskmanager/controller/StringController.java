package com.example.taskmanager.controller;

import com.example.taskmanager.service.StringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/strings")
public class StringController {

    @Autowired
    private StringService stringService;

    // Reverse the input string
    @GetMapping("/reverse")
    public String reverse(@RequestParam String input) {
        return stringService.reverse(input);
    }

    // Count the vowels in the input string
    @GetMapping("/countVowels")
    public long countVowels(@RequestParam String input) {
        return stringService.countVowels(input);
    }

    // Count the consonants in the input string
    @GetMapping("/countConsonants")
    public long countConsonants(@RequestParam String input) {
        return stringService.countConsonants(input);
    }

    // Convert the case of each character in the string
    @GetMapping("/convertCase")
    public String convertCase(@RequestParam String input) {
        return stringService.convertCase(input);
    }
}

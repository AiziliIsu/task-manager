package com.example.taskmanager.service;

import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class StringService {

    // Reverse the input string
    public String reverse(String input) {
        if (input == null || input.isEmpty()) {
            return input; // Return empty or null input as is
        }
        return new StringBuilder(input).reverse().toString();
    }

    // Count the number of vowels in the input string
    public long countVowels(String input) {
        if (input == null || input.isEmpty()) {
            return 0; // Return 0 for null or empty input
        }
        Set<Character> vowels = new HashSet<>();
        for (char c : "AEIOUaeiou".toCharArray()) {
            vowels.add(c);
        }
        return input.chars().filter(c -> vowels.contains((char) c)).count();
    }

    // Count the number of consonants in the input string
    public long countConsonants(String input) {
        if (input == null || input.isEmpty()) {
            return 0; // Return 0 for null or empty input
        }
        Set<Character> consonants = new HashSet<>();
        for (char c : "BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz".toCharArray()) {
            consonants.add(c);
        }
        return input.chars().filter(c -> consonants.contains((char) c)).count();
    }

    // Convert the case of each character in the string
    public String convertCase(String input) {
        if (input == null) {
            return null; // Return null if the input is null
        }
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append(Character.toLowerCase(c));
            } else {
                result.append(Character.toUpperCase(c));
            }
        }
        return result.toString();
    }
}

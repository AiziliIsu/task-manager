package com.example.taskmanager.service;

import org.springframework.stereotype.Service;

@Service
public class MathService {

    // Adds two numbers
    public double add(double a, double b) {
        return a + b;
    }

    // Subtracts b from a
    public double subtract(double a, double b) {
        return a - b;
    }

    // Multiplies two numbers
    public double multiply(double a, double b) {
        return a * b;
    }

    // Divides a by b
    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return a / b;
    }

    // Square root of a number
    public double squareRoot(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Cannot take the square root of a negative number.");
        }
        return Math.sqrt(a);
    }

    // Power of a number (a raised to the power of b)
    public double power(double a, double b) {
        return Math.pow(a, b);
    }

    // Modulus of a by b
    public double modulus(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed for modulus operation.");
        }
        return a % b;
    }
}

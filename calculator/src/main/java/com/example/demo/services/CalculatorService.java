package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int mod(int num1, int num2) {
        return num1 % num2;
    }

    public int min(int num1, int num2) {
        return Math.min(num1, num2);
    }

    public int max(int num1, int num2) {
        return Math.max(num1, num2);
    }

    public int pow(int num1, int num2) {
        return (int) Math.pow(num1, num2);
    }

    public int sub(int num1, int num2) {
        return num1 + num2;
    }

    public int mul(int num1, int num2) {
        return num1 * num2;
    }
    public int div(int num1, int num2) {
        return num1 / num2;
    }

}

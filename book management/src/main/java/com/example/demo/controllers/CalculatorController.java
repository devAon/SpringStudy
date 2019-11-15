package com.example.demo.controllers;

import com.example.demo.services.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/mod")
    public int mod(@RequestParam int num1, @RequestParam int num2){
        return calculatorService.mod(num1, num2);
    }
    @GetMapping("/min")
    public int min(@RequestParam int num1, @RequestParam int num2){
        return calculatorService.min(num1, num2);
    }

    @GetMapping("/max")
    public int max(@RequestParam int num1, @RequestParam int num2){
        return calculatorService.max(num1, num2);
    }
    @GetMapping("/pow")
    public int pow(@RequestParam int num1, @RequestParam int num2){
        return calculatorService.pow(num1, num2);
    }
    /*@GetMapping("/sub")
    public int sub(@RequestParam int num1, @RequestParam int num2){
        return num1 - num2;
    }

    @GetMapping("/mul")
    public int mul(@RequestParam int num1, @RequestParam int num2){
        return num1 * num2;
    }

    @GetMapping("/div")
    public int div(@RequestParam int num1, @RequestParam int num2){
        return num1 / num2;
    }*/

}


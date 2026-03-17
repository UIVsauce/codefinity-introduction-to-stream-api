package com.example;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // List of incomes
        List<Double> incomes = Arrays.asList(120000.0, 80000.0, 40000.0, 150000.0);

        // Function to calculate tax
        Function<Double, Double> calculateTax = income -> {
            if (income > 100000) {
                return income * 0.25;  // 25% tax
            } else if (income >= 50000) {
                return income * 0.15;  // 15% tax
            } else {
                return income * 0.05;  // 5% tax
            }
        };

        // Apply the function to all incomes
        List<Double> taxes = calculateTaxes(incomes, calculateTax);

        // Print the results
        taxes.forEach(tax -> System.out.println("Tax: " + tax));
    }

    public static List<Double> calculateTaxes(List<Double> incomes, Function<Double, Double> taxFunction) {
        List<Double> result = new ArrayList<>();
        for (Double income : incomes) {
            result.add(taxFunction.apply(income));  // Apply the tax calculation function
        }
        return result;
    }
}
package com.example;

import java.util.List;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = List.of(
            new Car(1, "Toyota Camry", 2022, 12000),
            new Car(2, "Ford Mustang", 2020, 45000),
            new Car(3, "Tesla Model 3", 2022, 6000),
            new Car(4, "Chevrolet Malibu", 2019, 32000),
            new Car(5, "Honda Accord", 2020, 25000)
        );

        List<String> processedCars = cars.stream()
            .filter(car -> car.getMileage() <= 30000)
            .sorted(Comparator.comparingInt(Car::getYear).reversed()
                .thenComparingInt(Car::getMileage))
            .map(Car::toString)
            .toList();

        processedCars.forEach(System.out::println);
    }
}

class Car {
    private int id;
    private String model;
    private int year;
    private int mileage;

    public Car(int id, String model, int year, int mileage) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    @Override
    public String toString() {
        return model + " (Year: " + year + ", Mileage: " + mileage + " miles)";
    }
}
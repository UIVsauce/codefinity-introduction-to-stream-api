package com.example;

import java.util.List;
import java.util.Arrays;
import java.util.function.BiPredicate;

public class Main {
    public static void main(String[] args) {
        // Creating a list of users
        List<User> users = Arrays.asList(
            new User("Alice", 22, "Active"),
            new User("Bob", 17, "Inactive"),
            new User("Charlie", 25, "Active"),
            new User("David", 16, "Active")
        );

        // Defining `BiPredicate` to check `age` and `status`
        BiPredicate<Integer, String> isEligible = (age, status) -> age > 18 && status.equals("Active");

        // Using `forEach` to iterate over the list
        users.forEach(user -> {
            // If the user satisfies the conditions, print the user
            if (isEligible.test(user.getAge(), user.getStatus())) {
                System.out.println(user); // Print the user
            }
        });
    }
}

class User {
    private String name;
    private int age;
    private String status;

    public User(String name, int age, String status) {
        this.name = name;
        this.age = age;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("User{name='%s', age=%d, status='%s'}", name, age, status);
    }
}
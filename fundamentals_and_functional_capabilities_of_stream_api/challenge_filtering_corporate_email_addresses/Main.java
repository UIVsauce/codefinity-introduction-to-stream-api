package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<String> emails = List.of(
            "john.doe@gmail.com",
            "alice@company.com",
            "bob@company.com",
            "test@yahoo.com",
            "charlie@company.com"
        );

        // `Predicate` for filtering corporate email addresses
        Predicate<String> corporateEmailFilter = email -> email.endsWith("@company.com");

        // Filter emails
        List<String> corporateEmails = filterEmails(emails, corporateEmailFilter);

        // Print the result
        System.out.println("Corporate email addresses: " + corporateEmails);
    }

    public static List<String> filterEmails(List<String> emails, Predicate<String> filter) {
        List<String> result = new ArrayList<>();
        for (String email : emails) {
            if (filter.test(email)) {
                result.add(email);
            }
        }
        return result;
    }
}
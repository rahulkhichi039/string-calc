package com.string;

import java.util.*;
import java.util.regex.*;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n"; // Default delimiters: comma and newline
        if (numbers.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(\\[.*?])+\\n").matcher(numbers);
            if (matcher.find()) {
                String delimiterSection = matcher.group();
                numbers = numbers.substring(delimiterSection.length()); // Remove delimiter section from numbers
                delimiter = parseDelimiters(delimiterSection);
            } else {
                delimiter = Pattern.quote(Character.toString(numbers.charAt(2)));
                numbers = numbers.substring(4);
            }
        }

        return calculateSum(numbers, delimiter);
    }

    private String parseDelimiters(String delimiterSection) {
        List<String> delimiters = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\[(.*?)]").matcher(delimiterSection);
        while (matcher.find()) {
            delimiters.add(Pattern.quote(matcher.group(1))); // Escape special characters
        }
        return String.join("|", delimiters);
    }

    private int calculateSum(String numbers, String delimiter) {
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String num : numbers.split(delimiter)) {
            if (!num.isEmpty()) {
                int value = Integer.parseInt(num);
                if (value < 0) {
                    negatives.add(value);
                } else if (value <= 1000) {
                    sum += value;
                }
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negatives);
        }

        return sum;
    }
}

package com.string;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {
    private final StringCalculator calculator = new StringCalculator();

    @Test
    void emptyStringReturnsZero() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    void singleNumberReturnsItself() {
        assertEquals(5, calculator.add("5"));
    }

    @Test
    void twoNumbersReturnTheirSum() {
        assertEquals(8, calculator.add("3,5"));
    }

    @Test
    void multipleNumbersReturnTheirSum() {
        assertEquals(15, calculator.add("1,2,3,4,5"));
    }

    @Test
    void newLineBetweenNumbersIsHandledCorrectly() {
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    void differentDelimiterIsSupported() {
        assertEquals(10, calculator.add("//;\n4;6"));
    }

    @Test
    void negativeNumberThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculator.add("-1"));
        assertEquals("Negative numbers not allowed: [-1]", exception.getMessage());
    }

    @Test
    void multipleNegativeNumbersThrowException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculator.add("-1,-2,-3"));
        assertEquals("Negative numbers not allowed: [-1, -2, -3]", exception.getMessage());
    }

    @Test
    void numbersGreaterThan1000AreIgnored() {
        assertEquals(2, calculator.add("1001,2"));
    }

    @Test
    void longCustomDelimiterIsSupported() {
        assertEquals(6, calculator.add("//[***]\n1***2***3"));
    }

    @Test
    void multipleCustomDelimitersAreSupported() {
        assertEquals(6, calculator.add("//[*][%]\n1*2%3"));
    }

    @Test
    void multipleCustomDelimitersWithDifferentLengthsAreSupported() {
        assertEquals(10, calculator.add("//[***][%%]\n3***4%%3"));
    }

    @Test
    void numbersGreaterThan1000AreIgnoredWithMultipleDelimiters() {
        assertEquals(3, calculator.add("//[*][%]\n1*1001%2"));
    }

    @Test
    void customDelimiterWithSpecialCharactersIsHandled() {
        assertEquals(6, calculator.add("//[$#]\n1$#2$#3"));
    }
}
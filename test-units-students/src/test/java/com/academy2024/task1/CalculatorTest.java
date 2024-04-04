package com.academy2024.task1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CalculatorTest {

    @InjectMocks
    private Calculator calculator;
    //addNumber
    @Test
    public void addNumber_shouldReturnCorrectSum_withPositiveNumbers() {

        int sum = calculator.addNumber(1, 2);
        int expected = 3;

        // 3 possible ways
        //assertEquals(sum, expected);
        //Assert.asserEquals(sum, expected);
        assertThat(sum).isEqualTo(expected);
    }

    @Test
    public void addNumber_shouldReturnCorrectSum_withNegativeNumbers() {

        int sum = calculator.addNumber(-2, -1);
        int expected = -3;

        assertEquals(sum, expected);
    }

    @Test
    public void addNumber_shouldReturnCorrectSum_withZeroAndNegativeNumbers() {

        int sum = calculator.addNumber(-2, 2);
        int expected = 0;

        assertEquals(sum, expected);
    }

    //subtractNumber
    @Test
    public void subtractNumbers_shouldReturnCorrectValue_withPositiveNumbers() {

        int subtraction = calculator.subtractNumber(20, 1);
        int expected = 19;

        assertEquals(subtraction, expected);
    }

    @Test
    public void subtractNumbers_shouldReturnCorrectValue_withNegativeNumbers() {

        int subtraction = calculator.subtractNumber(-2, -3);
        int expected = 1;

        assertEquals(subtraction, expected);
    }

    @Test
    public void subtractNumbers_shouldReturnCorrectValue_withZeroAndNegativeNumbers() {

        int subtraction = calculator.subtractNumber(0, -10);
        int expected = 10;

        assertEquals(subtraction, expected);
    }

    //multiplyNumber
    @Test
    public void multiplyNumbers_shouldReturnCorrectValue_withZeroAndNegativeNumbers() {

        int multiplication = calculator.multiplyNumber(0, -1);
        int expected = 0;

        assertEquals(multiplication, expected);
    }

    @Test
    public void multiplyNumbers_shouldReturnCorrectNumber_withPositiveNumbers() {

        int multiplication = calculator.multiplyNumber(10, 5);
        int expected = 50;

        assertEquals(multiplication, expected);
    }

    @Test
    public void multiplyNumbers_shouldReturnCorrectValue_withNegativeNumbers() {

        int multiplication = calculator.multiplyNumber(-10, -5);
        int expected = 50;

        assertEquals(multiplication, expected);
    }

    //divideNumber
    @Test
    public void divideNumbers_shouldReturnCorrectNumber_withPositiveNumbers() {

        int division = calculator.divideNumber(10, 2);
        int expected = 5;

        assertEquals(division, expected);
    }

    @Test
    public void divideNumbers_shouldReturnCorrectValue_withNegativeNumbers() {

        int division = calculator.divideNumber(-10, -2);
        int expected = 5;

        assertEquals(division, expected);
    }

    @Test
    public void divideNumbers_shouldReturnCorrectValue_withZeroNumber() {

        int division = calculator.divideNumber(0, 10);
        int expected = 0;

        assertEquals(division, expected);
    }

    //bonus
    @Test
    public void divideNumbers_shouldReturnException_whenDividingByZero() {

        Exception exception = assertThrows(ArithmeticException.class, () ->
            calculator.divideNumber(10, 0)
        );

        String message = "Cannot divide by 0";
        String exceptionMessage = exception.getMessage();
        assertEquals(exceptionMessage, message);
    }

    //findRemainder
    @Test
    public void findRemainder_shouldReturnCorrectNumber_withPositiveNumbers() {

        int remainder = calculator.findRemainder(16, 4);
        int expected = 0;

        assertEquals(remainder, expected);
    }

    @Test
    public void findRemainder_shouldReturnCorrectValue_withNegativeNumbers() {

        int remainder = calculator.findRemainder(-16, 4);
        int expected = 0;

        assertEquals(remainder, expected);
    }

    @Test
    public void findRemainder_shouldReturnCorrectValue_withZeroNumber() {

        int remainder = calculator.findRemainder(0, 4);
        int expected = 0;

        assertEquals(remainder, expected);
    }

    @Test
    public void findRemainder_shouldReturnException_whenDividingByZero() {

        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.findRemainder(10, 0);
        });

        String message = "Cannot divide by 0";
        String exceptionMessage = exception.getMessage();
        assertEquals(exceptionMessage, message);
    }
}

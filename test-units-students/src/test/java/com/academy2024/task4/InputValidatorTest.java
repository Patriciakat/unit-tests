package com.academy2024.task4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class InputValidatorTest {

    private static List<String> emailAddressList() {
        return Arrays.asList(
                "siksiksik@tarzanas.com",
                "as.maiklasjordanas@mail.com",
                "kametu.tapataikau@gmail.com");
    }

    private static List<String> invalidEmailAddressList() {
        return Arrays.asList(
                "a.@gmail.com",
                ".s.@gmail.com",
                "sik@.com");
    }

    public static List<String> phoneNumbersList() {
        return Arrays.asList(
                "+37060012345",
                "860000000",
                "869813205",
                "+37063663202"
        );
    }

    public static List<String> invalidPhoneNumbersList() {
        return Arrays.asList(
                "86981320",
                "3268102",
                "+370632",
                "sjfrfi0"
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
    void isEven_ShouldReturnFalseForOddNumbers(int number) {

        assertFalse(InputValidator.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {8, 146, Integer.MAX_VALUE - 1})
    void isEven_ShouldReturnTrueForEvenNumbers(int number) {

        assertTrue(InputValidator.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "0"})
    void isBlank_ShouldReturnFalseForNonBlankStrings(String input) {

        assertFalse(InputValidator.isBlank(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void isBlank_ShouldReturnTrueForEmptyOrBlankStrings(String input) {

        assertTrue(InputValidator.isBlank(input));
    }

    @ParameterizedTest
    @MethodSource("emailAddressList")
    public void isValidEmail_ShouldReturnTrueForValidStrings(String emailAddress) {

        assertTrue(InputValidator.isValidEmail(emailAddress));
    }

    @ParameterizedTest
    @MethodSource("invalidEmailAddressList")
    public void isValidEmail_ShouldReturnFalseForInvalidStrings(String emailAddress) {

        assertFalse(InputValidator.isValidEmail(emailAddress));
    }

    @ParameterizedTest
    @MethodSource("phoneNumbersList")
    public void isValidPhoneNumber_ShouldReturnTrueForValidPhoneNumbers(String phoneNumber) {

        String actual = InputValidator.isValidPhoneNumber(phoneNumber);
        String expected = "Valid";
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("invalidPhoneNumbersList")
    public void isValidPhoneNumber_ShouldReturnFalseForInvalidPhoneNumbers(String phoneNumber) {

        String actual = InputValidator.isValidPhoneNumber(phoneNumber);
        String expected = "Invalid";
        assertEquals(expected, actual);
    }
}
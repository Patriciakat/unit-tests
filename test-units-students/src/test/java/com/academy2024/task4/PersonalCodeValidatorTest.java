package com.academy2024.task4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonalCodeValidatorTest {

    public static List<String> personalCodeList() {
        return Arrays.asList(
                "4950801123",
                "5220229123",
                "89508011234"
        );
    }

    @Test
    public void personal_code_validator_should_print_female_born_1995() {
        String expected = "Gender female, birth year: 1995";
        String actual = PersonalCodeValidator.printData("49508011234");
        assertEquals(actual, expected);
    }

    @Test
    public void personal_code_validator_should_print_female_born_1999() {
        String expected = "Gender female, birth year: 1999";
        String actual = PersonalCodeValidator.printData("49908081234");
        assertEquals(actual, expected);
    }

    @Test
    public void personal_code_validator_should_print_male_born_2020() {
        final String expected = "Gender male, birth year: 2020";
        final String actual = PersonalCodeValidator.printData("52002291234");
        assertEquals(actual, expected);
    }

    @Test
    public void personal_code_validator_should_print_male_born_1999() {
        String expected = "Gender male, birth year: 1999";
        String actual = PersonalCodeValidator.printData("39908081234");
        assertEquals(actual, expected);
    }

    @Test
    public void personal_code_validator_should_print_male_born_2022() {
        final String expected = "Gender male, birth year: 2022";
        final String actual = PersonalCodeValidator.printData("52202291234");
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @MethodSource("personalCodeList")
    public void personal_code_validator_should_print_invalid(String personalCode) {

        final String expected = "Invalid personal code";
        final String actual = PersonalCodeValidator.printData(personalCode);

        assertEquals(actual, expected);
    }
}
package com.academy2024.task4;

import java.util.regex.Pattern;

public class PersonalCodeValidator {

    private static final String PERSONAL_CODE_REGX = "^(1|2|3|4|5|6)[0-9]{10}$";

    public static String printData(String personalCode) {

        String gender = determineGender(personalCode).getGender();
        String birthYear = determineBirthYear(personalCode);

        if (isValidPersonalCode(personalCode, PERSONAL_CODE_REGX)) {
            return "Gender " + gender + ", birth year: " + birthYear;
        } else {
            return "Invalid personal code";
        }
    }

    public static boolean isValidPersonalCode(String personalCode, String regex) {
        return Pattern.compile(regex)
                .matcher(personalCode)
                .matches();
    }

    public static Gender determineGender(String personalCode) {

        if (personalCode.startsWith("2") || personalCode.startsWith("4") || personalCode.startsWith("6")) {
            return Gender.FEMALE;
        } else return Gender.MALE;
    }

    public static String determineBirthYear(String personalCode) {

        int birthYear = extractDigits(personalCode, 1, 3);

        return switch (extractDigits(personalCode, 0, 1)) {
            case 1, 2 -> String.valueOf(1800 + birthYear);
            case 4, 3 -> String.valueOf(1900 + birthYear);
            case 5, 6 -> String.valueOf(2000 + birthYear);
            default -> "Invalid";
        };
    }

    public static int extractDigits(String personalCode, int start, int end) {
        return Integer.parseInt(personalCode.substring(start, end));
    }
}

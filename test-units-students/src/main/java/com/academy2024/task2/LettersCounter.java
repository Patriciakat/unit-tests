package com.academy2024.task2;

import java.util.List;

public class LettersCounter {
    public int countLettersInString(char letter, String str) {

        int counter = 0;
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == letter) {
                counter++;
            }
        }
        return counter;
    }

    public int countLettersInStrings(char letter, List<String> list) {

        int counter = 0;
        for (int i = 0; i < list.size(); i++) {

            for (int j = 0; j < list.get(i).length(); j++) {

                if (list.get(i).charAt(j) == letter) {
                    counter++;
                }
            }
        }
        return counter;

    }
}

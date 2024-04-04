package com.academy2024.task2;

import com.academy2024.task1.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class LettersCounterTest {

    @InjectMocks
    private LettersCounter lettersCounter;

    @Test
    public void countLettersInString_shouldReturnCorrectNumber_withOneOccurrence() {

        int counter = lettersCounter.countLettersInString('i', "Hi");
        int expected = 1;

        assertEquals(counter, expected);
    }

    @Test
    public void countLettersInString_shouldReturnCorrectNumber_withMultipleOccurrences() {

        int counter = lettersCounter.countLettersInString('i', "Hii!i");
        int expected = 3;

        assertEquals(counter, expected);
    }

    @Test
    public void countLettersInString_shouldReturnZero_withNoOccurrences() {

        int counter = lettersCounter.countLettersInString('i', "Academy");
        int expected = 0;

        assertEquals(counter, expected);
    }

    @Test
    public void countLettersInString_shouldReturnZero_withStringIsEmpty() {

        int counter = lettersCounter.countLettersInString('i', "");
        int expected = 0;

        assertEquals(counter, expected);
    }

    @Test
    public void countLettersInStrings_shouldReturnZero_withStringIsEmpty() {

        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("orange");

        int counter = lettersCounter.countLettersInStrings('i', list);
        int expected = 0;

        assertEquals(counter, expected);

    }
}
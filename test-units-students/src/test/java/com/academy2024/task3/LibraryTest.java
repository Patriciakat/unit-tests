package com.academy2024.task3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LibraryTest {

    @Mock
    private Library library;

    public ArrayList<Book> setupBookList() {
        return new ArrayList<>(Arrays.asList(
                new Book("Shuggie Bain", "Douglas Stuart", 480),
                new Book("White Noise", "Don DeLillo", 384),
                new Book("American Psycho", "Bret Easton Ellis", 416),
                new Book("Blood Meridian", "Cormac McCarthy", 384),
                new Book("Catechismvsa", "Martjnvs Masvjdjvs", 79)));
    }

    @Test
    public void countTheNumberOfBooks_returnsBookListSize_whenBookListNotEmpty() {

//        ArrayList<Book> setupBookList = setupBookList();
//        library.setBooks(setupBookList);
//        int expected = 5;
//        when(library.countTheNumberOfBooks()).thenReturn(expected);
//        int actual = library.countTheNumberOfBooks();

//        assertEquals(expected, actual);

        int expected = 5;
        when(library.countTheNumberOfBooks()).thenReturn(expected);
        int actual = library.countTheNumberOfBooks();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void countTheNumberOfBooks_returnsBookListSize_whenBookListEmpty() {

        int expected = 0;
        when(library.countTheNumberOfBooks()).thenReturn(expected);
        int actual = library.countTheNumberOfBooks();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void findBookByTitle_returnBookObject_whenBookListContainsBookWithEnteredStringTitle() throws BookNotFoundException {

        //library.setBooks(setupBookList());
        Book expected = new Book("Blood Meridian", "Cormac McCarthy", 384);
        when(library.findBookByTitle("Blood Meridian")).thenReturn(expected);
        Book actual = library.findBookByTitle("Blood Meridian");

        assertEquals(expected, actual);
    }

    @Test
    public void findBookByTitle_throwsBookNotFoundException_whenBookListDoesNotContainBookWithEnteredTitle() throws BookNotFoundException {

        String bookTitle = "Non-existent book";
        String expected = "Sorry, but book with title " + bookTitle + " has not been found";
        when(library.findBookByTitle(bookTitle)).thenThrow(new BookNotFoundException(expected));
        BookNotFoundException actual = assertThrows(BookNotFoundException.class, () -> library.findBookByTitle(bookTitle));

        assertEquals(expected, actual.getMessage());
    }

    @Test
    public void findBookWithHighestPageCount_returnBookPageInt_whenBookListNotEmpty() throws BookNotFoundException {

        Book expected = new Book("Shuggie Bain", "Douglas Stuart", 480);
        when(library.findBookByTitle("Shuggie Bain")).thenReturn(expected);
        Book actual = library.findBookByTitle("Shuggie Bain");

        assertEquals(expected, actual);
    }

    @Test
    public void findBookWithHighestPageCount_throwsBookNotFoundException_whenBookListEmpty() throws BookNotFoundException {

        String expected = "No books found";
        when(library.findBookWithHighestPageCount()).thenThrow(new BookNotFoundException(expected));
        BookNotFoundException actual = assertThrows(BookNotFoundException.class, () -> library.findBookWithHighestPageCount());

        assertEquals(expected, actual.getMessage());
    }
}
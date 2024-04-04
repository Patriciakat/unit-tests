package com.academy2024.task3;

import java.util.*;

public class Library {

    private ArrayList<Book> books;

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public int countTheNumberOfBooks() {
        return books.size();
    }

    public Book findBookByTitle(String bookTitle) throws BookNotFoundException {

        for (Book book : books) {

            if (Objects.equals(book.getTitle(), bookTitle)) {
                return book;
            }
        }
        throw new BookNotFoundException("Sorry, but book with title " + bookTitle + " has not been found");
    }

    public Book findBookWithHighestPageCount() throws BookNotFoundException {

        if(!books.isEmpty()) {
            return books.stream().max(Comparator.comparing(Book :: getNumberOfPages)).orElseThrow();
        }

        throw new BookNotFoundException("No books found");
    }
}

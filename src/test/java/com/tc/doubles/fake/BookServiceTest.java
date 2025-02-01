package com.tc.doubles.fake;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class BookServiceTest {

    private BookService bookService;

    @BeforeEach
    public void setUp() {
        BookRepository bookRepository = new FakeBookRepository();
        bookService = new BookService(bookRepository);
    }
    @Test
    public void shouldSaveBooksCorrectly() {

        addNumberOfBooks(5);

        Assertions.assertTrue(bookService.findNumbersOfBook() == 5);

    }

    private void addNumberOfBooks(int numbers) {
        for(int i = 1; i <= numbers; i++) {
            bookService.addBook(createBook(i));
        }
    }

  private Book createBook(int bookId) {
        return new Book("Book "+bookId, String.valueOf(bookId), 100 * bookId, LocalDate.now());
  }
}

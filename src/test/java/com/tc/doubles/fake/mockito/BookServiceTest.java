package com.tc.doubles.fake.mockito;

import com.tc.doubles.fake.Book;
import com.tc.doubles.fake.BookRepository;
import com.tc.doubles.fake.BookService;
import com.tc.doubles.fake.FakeBookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BookServiceTest {

    private BookService bookService;
    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository = Mockito.mock(BookRepository.class);
        bookService = new BookService(bookRepository);
    }
    @Test
    public void shouldSaveBooksCorrectly() {

        Collection<Book> books = addNumberOfBooks(5);

        Mockito.when(bookRepository.findAll()).thenReturn(books);

        Assertions.assertTrue(bookService.findNumbersOfBook() == 5);

    }

    private Collection<Book> addNumberOfBooks(int numbers) {
        Collection<Book> books = new ArrayList<>();
        for(int i = 1; i <= numbers; i++) {
            books.add(createBook(i));
        }
        return books;
    }

    private Book createBook(int bookId) {
        return new Book("Book "+bookId, String.valueOf(bookId), 100 * bookId, LocalDate.now());
    }
}

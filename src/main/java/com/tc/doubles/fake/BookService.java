package com.tc.doubles.fake;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(final Book book) {
        bookRepository.save(book);
    }

    public int findNumbersOfBook() {
        return bookRepository.findAll().size();
    }

}

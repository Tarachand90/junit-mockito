package com.tc.doubles.fake;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeBookRepository implements BookRepository{

    Map<String, Book> database = new HashMap<>();

    @Override
    public void save(Book book) {
        database.put(book.getBookId(), book);
    }

    @Override
    public Collection<Book> findAll() {
        return database.values();
    }
}

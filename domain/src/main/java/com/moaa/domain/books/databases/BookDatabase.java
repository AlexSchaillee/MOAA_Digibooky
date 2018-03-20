package com.moaa.domain.books.databases;

import com.moaa.domain.books.Book;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

@Named
public class BookDatabase {

    private List<Book> books;

    public BookDatabase() {
        this.books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return unmodifiableList(books);
    }
}

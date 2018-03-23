package com.moaa.domain.books;

import com.moaa.domain.books.databases.BookDatabase;
import com.moaa.domain.books.properties.Author;
import com.moaa.domain.books.properties.Isbn;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Named
public class BookRepository {

    @Inject
    private BookDatabase bookDatabase;

    public List<Book> getBooks() {
        return bookDatabase.getBooks();
    }

    public Book createBook(Book book) {
        return bookDatabase.createBook(book);
    }

    public List<Book> createBook(List<Book> books) {
        return bookDatabase.createBook(books);
    }

    public void deleteBook(List<Book> listOfBooksToSoftDelete) {
        bookDatabase.delete(listOfBooksToSoftDelete);
    }

    public void clearDatabase() {
        bookDatabase.clear();
    }

    public List<Book> getSoftDeletedBooks() {
        return bookDatabase.getSoftDeletedBooks();
    }

    public void deleteSoftDeletedBooks(List<Book> booksToRestore) {
        bookDatabase.deleteSoftDeletedBooks(booksToRestore);
    }
}

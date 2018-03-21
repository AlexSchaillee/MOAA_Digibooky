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

    public Book searchBookByAuthorNamePart(String authorNamePart) {
        for (Book book : getBooks()) {
            if (book.getAuthor().getFirstName().concat(book.getAuthor().getLastName()).contains(authorNamePart)
                    || book.getAuthor().getLastName().concat(book.getAuthor().getFirstName()).contains(authorNamePart)) {
                return book;
            }
        }
        throw new IllegalArgumentException("Book not found.");
    }

    /*public void deleteBook(String isbnString) {
        try {
            for (Book book : searchBookByIsbnPart(isbnString))
            bookDatabase.delete(book);
        } catch (IllegalArgumentException e) {
            System.out.println("No book found with the given ISBN.");
        }
    }*/

    /*public Book updateBook(String isbnString, Book book) {
        deleteBook(isbnString);
        return createBook(book);
    }*/

    public void clearDatabase() {
        bookDatabase.clear();
    }
}

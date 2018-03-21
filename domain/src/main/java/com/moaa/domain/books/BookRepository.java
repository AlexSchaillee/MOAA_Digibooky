package com.moaa.domain.books;

import com.moaa.domain.books.databases.BookDatabase;

import javax.inject.Inject;
import javax.inject.Named;
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

    public Book createBook(String isbn, String title, Author author) {
        return bookDatabase.createBook(isbn, title, author);
    }

    public String showDetailsOfBook(UUID bookId) {
        String detailsOfBook = bookDatabase.getBooks().stream()
                .filter(b->b.getId().equals(bookId))
                .findFirst()
                .get()
                .toString();
        if (detailsOfBook == null) {
            throw new NoSuchElementException();
        }
        return detailsOfBook;
    }
}

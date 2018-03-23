package com.moaa.service.books;

import com.moaa.domain.books.Book;
import com.moaa.domain.books.BookRepository;
import com.moaa.domain.books.properties.Author;
import com.moaa.domain.books.properties.Isbn;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

// adapted code from funiversity
@Named
public class BookService {

    private final BookRepository bookRepository;

    @Inject
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

    public List<Book> getSoftDeletedBooks() {
        return bookRepository.getSoftDeletedBooks();
    }

    public List<Book> getBooksByIsbn(String isbnString) {
        return getBooks().stream()
                .filter(b->b.getIsbn().getIsbnNumber().equals(isbnString))
                .collect(toList());
    }

    public List<Book> getBooksByTitle(String titlePartValue) {
        return getBooks().stream()
                .filter(b->b.getTitle().contains(titlePartValue))
                .collect(toList());
    }


    public Book createBook(Book book) {
        return bookRepository.createBook(book);
    }

    public List<Book> getBooksByAuthorName(String authorNamePart) {
        List<Book> foundBooks = new ArrayList<>();
        for (int index=0; index<getBooks().size(); index++) {
            if (bookAuthorContainsAuthorNamePart(authorNamePart, index)) {
                foundBooks.add(getBooks().get(index));
            }
        }
        return foundBooks;
    }

    public List<Book> updateBook(String isbnString, Book book) {
        List<Book> booksToUpdate = getBooksByIsbn(isbnString);
        for (int index=0; index<booksToUpdate.size(); index++) {
            booksToUpdate.get(index).setAuthor(book.getAuthor());
            booksToUpdate.get(index).setTitle(book.getTitle());
        }
        return booksToUpdate;
    }

    private boolean bookAuthorContainsAuthorNamePart(String authorNamePart, int index) {
        return getBooks().get(index).getAuthor().getFirstName()
                .concat(getBooks().get(index).getAuthor().getLastName())
                .contains(authorNamePart)
                || getBooks().get(index).getAuthor().getLastName()
                .concat(getBooks().get(index).getAuthor().getFirstName())
                .contains(authorNamePart);
    }

    public void deleteBook(String isbnString) {
        List<Book> booksToSoftDelete = new ArrayList<>();
        booksToSoftDelete.addAll(getBooksByIsbn(isbnString));
        bookRepository.deleteBook(booksToSoftDelete);
    }

    public void clearDatabase() {
        bookRepository.clearDatabase();
    }

    public void restoreBook(String isbn) {
        bookRepository.createBook(getSoftDeletedBooksByIsbn(isbn));
        bookRepository.deleteSoftDeletedBooks(getSoftDeletedBooksByIsbn(isbn));
    }

    private List<Book> getSoftDeletedBooksByIsbn(String isbn) {
        return getSoftDeletedBooks().stream()
                .filter(b->b.getIsbn().equals(isbn))
                .collect(toList());
    }
}

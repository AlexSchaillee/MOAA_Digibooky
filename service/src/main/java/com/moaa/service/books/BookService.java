package com.moaa.service.books;

import com.moaa.domain.books.Book;
import com.moaa.domain.books.BookRepository;
import com.moaa.domain.books.properties.Author;
import com.moaa.domain.books.properties.Isbn;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.UUID;

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

    public Book getBook(String isbn) {
        return bookRepository.getBook(isbn);
    }

    /*public String showDetailsOfBook(Isbn isbn){
        return bookRepository.showDetailsOfBook(isbn);
    }*/

    public List<Book> searchBookByIsbnPart(String isbnPart) {
        return bookRepository.searchBookByIsbnPart(isbnPart);
    }

    public Book createBook(Book book) {
        return bookRepository.createBook(book);
    }

    public Book searchBookByTitlePart(String titlePart) {
        return bookRepository.searchBookByTitlePart(titlePart);
    }

    public Book searchBookByAuthorNamePart(String authorNamePart) {
        return bookRepository.searchBookByAuthorNamePart(authorNamePart);
    }

    public void deleteBoook(String isbnString) {
        bookRepository.deleteBook(isbnString);
    }

    public Book updateBook(String isbnString, Book book) {
        return bookRepository.updateBook(isbnString, book);
    }

    public void clearDatabase() {
        bookRepository.clearDatabase();
    }
}

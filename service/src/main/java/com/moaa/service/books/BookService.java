package com.moaa.service.books;

import com.moaa.domain.books.Book;
import com.moaa.domain.books.BookRepository;
import com.moaa.domain.books.properties.Author;
import com.moaa.domain.books.properties.Isbn;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public List<Book> getBooksByIsbn(String isbnString) throws NoSuchElementException{
        return getBooks().stream()
                .filter(b->b.getIsbn().equals(Isbn.convertStringToIsbn(isbnString)))
                .collect(Collectors.toList());
    }

    public List<Book> getBooksByTitle(String titlePartValue) {
        return getBooks().stream()
                .filter(b->b.getTitle().contains(titlePartValue))
                .collect(Collectors.toList());
    }


    public Book createBook(Book book) {
        return bookRepository.createBook(book);
    }

    public List<Book> getBooksByAuthorName(String authorNamePart) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : getBooks()) {
            if (book.getAuthor().getFirstName().concat(book.getAuthor().getLastName()).contains(authorNamePart)
                    || book.getAuthor().getLastName().concat(book.getAuthor().getFirstName()).contains(authorNamePart)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    /*public void deleteBoook(String isbnString) {
        bookRepository.deleteBook(isbnString);
    }*/

/*
    public Book updateBook(String isbnString, Book book) {
        return bookRepository.updateBook(isbnString, book);
    }
*/

    public void clearDatabase() {
        bookRepository.clearDatabase();
    }
}

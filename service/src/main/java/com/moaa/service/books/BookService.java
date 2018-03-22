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
        for (int index=0; index<getBooks().size(); index++) {
            if (bookAuthorContainsAuthorNamePart(authorNamePart, index)) {
                foundBooks.add(getBooks().get(index));
            }
        }
        return foundBooks;
    }

    public List<Book> updateBook(String isbnString, String newTitle, Author newAuthor) {
        List<Book> booksToUpdate = getBooksByIsbn(isbnString);
        for (int index=0; index<booksToUpdate.size(); index++) {
            bookRepository.updateBook(index, newTitle, newAuthor);
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

    public void deleteBook(String isbnString) throws IllegalArgumentException{
        List<Book> booksToSoftDelete = new ArrayList<>();
        if (getBooksByIsbn(isbnString).size() == 0) {
            throw new IllegalArgumentException("No book found with given ISBN.");
        }
        booksToSoftDelete.addAll(getBooksByIsbn(isbnString));
        bookRepository.deleteBook(booksToSoftDelete);
    }

    public void clearDatabase() {
        bookRepository.clearDatabase();
    }
}

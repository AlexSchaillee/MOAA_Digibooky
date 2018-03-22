package com.moaa.domain.books.databases;

import com.moaa.domain.books.properties.Author;
import com.moaa.domain.books.Book;
import com.moaa.domain.books.properties.Isbn;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

import static com.moaa.domain.books.Book.BookBuilder.book;
import static java.util.Collections.unmodifiableList;

@Named
public class BookDatabase {

    private List<Book> books;
    private List<Book> softDeletedBooks;

    public BookDatabase() {
        this.books = new ArrayList<>();
        this.softDeletedBooks = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return unmodifiableList(books);
    }

    public Book createBook(Book book) {
        books.add(book);
        return book;
    }

    public void delete(List<Book> listOfBooksToSoftDelete) {
        for (int index=0; index<listOfBooksToSoftDelete.size(); index++) {
            books.remove(listOfBooksToSoftDelete.get(index));
            softDeletedBooks.add(listOfBooksToSoftDelete.get(index));
        }
    }

    public void clear() {
        books.clear();
        softDeletedBooks.clear();
    }

    public Book updateBook(int index, String newTitle, Author newAuthor) {
        books.get(index).setTitle(newTitle);
        books.get(index).setAuthor(newAuthor);
        return books.get(index);
    }
}

package com.moaa.domain.books;

import com.moaa.domain.books.properties.Author;
import com.moaa.domain.books.properties.Isbn;

import java.util.Objects;
import java.util.UUID;
// copied from example code

public class Book {

    private UUID id;
    private String title;
    private Author author;
    private Isbn isbn;
    private Long lendingPeriodInDays;

    private Book(String title, Author author, Isbn isbn) {
        id = UUID.randomUUID();
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.lendingPeriodInDays = null;
    }

    public Long getLendingPeriodInDays() {
        return lendingPeriodInDays;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public Isbn getIsbn() {
        return isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(isbn, book.isbn);
    }

    @Override
    public String toString() {
        return isbn + "\n" + title + "\n" + author.getFirstName() + " " + author.getLastName();
    }

    @Override
    public int hashCode() { return Objects.hash(id, title, author, isbn); }

    public static class BookBuilder {
        private String title;
        private Author author;
        private Isbn isbn;

        private BookBuilder(){}

        public static BookBuilder book() {
            return new BookBuilder();
        }

        public Book build() {
            return new Book(title, author, isbn);
        }

        public BookBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder withAuthor(Author author) {
            this.author = author;
            return this;
        }

        public BookBuilder withIsbn(Isbn isbn) {
            this.isbn = isbn;
            return this;
        }
    }
}

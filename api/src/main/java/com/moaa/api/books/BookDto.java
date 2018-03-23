package com.moaa.api.books;

import java.util.Objects;

public class BookDto {

    private String title;
    private AuthorDto author;
    private IsbnDto isbn;

    public static BookDto bookDto(){
        return new BookDto();
    }

    public BookDto withTitle(String title){
        this.title = title;
        return this;
    }

    public BookDto withAuthorDto(AuthorDto authorDto){
        this.author = authorDto;
        return this;
    }

    public BookDto withIsbnDto(IsbnDto isbn){
        this.isbn = isbn;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public IsbnDto getIsbn() {
        return isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto bookDto = (BookDto) o;
        return Objects.equals(title, bookDto.title) &&
                Objects.equals(author, bookDto.author) &&
                Objects.equals(isbn, bookDto.isbn);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, author, isbn);
    }
}

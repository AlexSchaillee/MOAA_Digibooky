package com.moaa.api.books;

import com.moaa.domain.books.Author;

public class BookDto {

    private String title;
    private AuthorDto authorDto;
    private String isbn;

    public static BookDto bookDto(){
        return new BookDto();
    }

    public BookDto withTitle(String title){
        this.title = title;
        return this;
    }

    public BookDto withAuthorDto(AuthorDto authorDto){
        this.authorDto = authorDto;
        return this;
    }

    public BookDto withIsbn(String isbn){
        this.isbn = isbn;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public AuthorDto getAuthorDto() {
        return authorDto;
    }

    public String getIsbn() {
        return isbn;
    }
}

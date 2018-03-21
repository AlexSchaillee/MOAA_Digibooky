package com.moaa.api.books;

import com.moaa.domain.books.properties.Isbn;

public class BookDto {

    private String title;
    private AuthorDto authorDto;
    private Isbn isbn;

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

    public BookDto withIsbn(Isbn isbn){
        this.isbn = isbn;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public AuthorDto getAuthorDto() {
        return authorDto;
    }

    public Isbn getIsbn() {
        return isbn;
    }
}

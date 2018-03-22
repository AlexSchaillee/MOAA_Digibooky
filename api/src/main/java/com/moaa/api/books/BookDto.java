package com.moaa.api.books;

public class BookDto {

    private String title;
    private AuthorDto author;
    private String isbn;

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

    public BookDto withIsbn(String isbn){
        this.isbn = isbn;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }
}

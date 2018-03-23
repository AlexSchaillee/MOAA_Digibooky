package com.moaa.api.books;

import com.moaa.domain.books.Book;
import com.moaa.domain.books.properties.Isbn;

import javax.inject.Inject;
import javax.inject.Named;

import java.util.ArrayList;
import java.util.List;

import static com.moaa.domain.books.Book.BookBuilder.book;

@Named
public class BookMapper{
    @Inject
    private AuthorMapper authorMapper;
    @Inject
    private IsbnMapper isbnMapper;

    public BookDto toDto(Book book){
        return BookDto.bookDto()
                .withTitle(book.getTitle())
                .withAuthorDto(authorMapper.toDto(book.getAuthor()))
                .withIsbnDto(isbnMapper.toDto(book.getIsbn()));
    }

    public List<BookDto> toDto(List<Book> books){
        List<BookDto> bookDtos = new ArrayList<>();
        if (books.isEmpty()) { return bookDtos; }
        for (Book book : books) {
            bookDtos.add(toDto(book));
        }
        return bookDtos;
    }

    public Book toDomain(BookDto bookDto){
        return book()
                .withTitle(bookDto.getTitle())
                .withAuthor(authorMapper.toDomain(bookDto.getAuthor()))
                .withIsbn(isbnMapper.toDomain(bookDto.getIsbn()))
                .build();
    }
}

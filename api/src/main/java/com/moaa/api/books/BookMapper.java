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

    public BookDto toDto(Book book){
        return BookDto.bookDto()
                .withTitle(book.getTitle())
                .withAuthorDto(authorMapper.toDto(book.getAuthor()))
                .withIsbn(book.getIsbn().getIsbnNumber());
    }

    List<BookDto> toDto(List<Book> books){
        List<BookDto> bookDtos = new ArrayList<>();
        for (Book book : books) {
            bookDtos.add(toDto(book));
        }
        return bookDtos;
    }

    public Book toDomain(BookDto bookDto){
        return book()
                .withTitle(bookDto.getTitle())
                .withAuthor(authorMapper.toDomain(bookDto.getAuthor()))
                .withIsbn(Isbn.convertStringToIsbn(bookDto.getIsbn()))
                .build();
    }
}

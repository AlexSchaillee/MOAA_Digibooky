package com.moaa.api.books;

import com.moaa.domain.books.Book;

import javax.inject.Named;

import static com.moaa.domain.books.Book.BookBuilder.book;

@Named
public class BookMapper{
    private AuthorMapper authorMapper;

    BookDto toDto(Book book){
        return BookDto.bookDto()
                .withTitle(book.getTitle())
                .withAuthorDto(authorMapper.toDto(book.getAuthor()))
                .withIsbn(book.getIsbn());
    }

    Book toDomain(BookDto bookDto){
        return book()
                .withTitle(bookDto.getTitle())
                .withAuthor(authorMapper.toDomain(bookDto.getAuthorDto()))
                .withIsbn(bookDto.getIsbn())
                .build();
    }
}

package com.moaa.api.books;

// copied code from funiversity example

import com.moaa.service.books.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    private BookService bookService;
    private BookMapper bookMapper;

    @Inject
    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getBooks() {
        return bookService.getBooks().stream()
                .map(bookMapper::toDto)
                .collect(toList());
    }

    @GetMapping(path = "/{isbn}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BookDto getBook(@PathVariable("isbn") String isbn) {
        return bookMapper
                .toDto(bookService.getBook(isbn));
    }

    @GetMapping(path = "/searchBookByIsbn/?isbn={isbnPart}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BookDto searchBookByIsbnPart(@PathVariable("isbnPart") String isbnPart) {
        return bookMapper
                .toDto(bookService.searchBookByIsbnPart(isbnPart));
    }

    @GetMapping(path = "/searchBookByTitle/?title={titlePart}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BookDto searchBookByTitlePart(@PathVariable("titlePart") String titlePart) {
        return bookMapper
                .toDto(bookService.searchBookByTitlePart(titlePart));
    }

    @GetMapping(path = "/searchBookByAuthor/?author={authorNamePart}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BookDto searchBookByAuthorNamePart(@PathVariable("authorNamePart") String authorNamePart) {
        return bookMapper
                .toDto(bookService.searchBookByAuthorNamePart(authorNamePart));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto createBook(@RequestBody BookDto bookDto) {
        return bookMapper
                .toDto(bookService.createBook(bookMapper.toDomain(bookDto)));
    }

    @PutMapping(path = "/{isbn}", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BookDto updateBook(@PathVariable String isbnString, @RequestBody BookDto bookDto) {
        return bookMapper
                .toDto(bookService.updateBook(isbnString, bookMapper.toDomain(bookDto)));
    }

    @DeleteMapping(path = "/{isbnString}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable String isbnString) {
        bookService.deleteBoook(isbnString);
    }

}

package com.moaa.api.books;

// copied code from funiversity example

import com.moaa.domain.books.Book;
import com.moaa.service.books.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;
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

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto createBook(@RequestBody BookDto bookDto) {
        return bookMapper
                .toDto(bookService.createBook(bookMapper.toDomain(bookDto)));
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
    public List<BookDto> getBooksByIsbn(@PathVariable("isbnPart") String isbnPartValue) {
        List<BookDto> foundBooks = bookMapper.toDto(bookService.getBooksByIsbn(isbnPartValue));
        if (foundBooks.isEmpty()) {
            throw new IllegalArgumentException("No books found with given ISBN.");
        }
        return foundBooks;
    }
    //https://stackoverflow.com/questions/34587254/accessing-multiple-controllers-with-same-request-mapping
    @GetMapping(path = "/search", params = "title", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getBooksByTitle(@RequestParam("title") String titlePartValue) {
        List<BookDto> foundBooks = bookMapper.toDto(bookService.getBooksByTitle(titlePartValue));
        if (foundBooks.isEmpty()) {
            throw new IllegalArgumentException("No books found with given title.");
        }
        return foundBooks;
    }

    @GetMapping(path = "/search", params = "author", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getBooksByAuthorName(@RequestParam("author") String authorNamePartValue) {
        List<BookDto> foundBooks = bookMapper.toDto(bookService.getBooksByAuthorName(authorNamePartValue));
        if (foundBooks.isEmpty()) {
            throw new IllegalArgumentException("No books found with given author's name.");
        }
        return foundBooks;
    }

    /*@GetMapping(path = "/{title}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BookDto getBookByTitle(@PathVariable("title") String title) {
        return bookMapper
                .toDto(bookService.getBook(title));
    }*/

    /*@GetMapping(path = "/search-book-by-isbn", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> searchBookByIsbnPart(@RequestParam("isbnPart") String isbnPartValue) {
        List<BookDto> booksDto = new ArrayList<>();
        for (Book book : bookService.searchBookByIsbnPart(isbnPartValue)) {
            booksDto.add(bookMapper.toDto(book));
        }
        return booksDto;
    }

    @GetMapping(path = "/search-book-by-title", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BookDto searchBookByTitlePart(@RequestParam("titlePart") String titlePart) {
        return bookMapper
                .toDto(bookService.searchBookByTitlePart(titlePart));
    }

    /*@PutMapping(path = "/{isbn}", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BookDto updateBook(@PathVariable String isbnString, @RequestBody BookDto bookDto) {
        return bookMapper
                .toDto(bookService.updateBook(isbnString, bookMapper.toDomain(bookDto)));
    }

    @DeleteMapping(path = "/{isbnString}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable String isbnString) {
        bookService.deleteBoook(isbnString);
    }*/

}

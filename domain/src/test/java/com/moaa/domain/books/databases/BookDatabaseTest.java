package com.moaa.domain.books.databases;

import com.moaa.domain.books.Book;
import com.moaa.domain.books.properties.Author;
import com.moaa.domain.books.properties.Isbn;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.moaa.domain.books.Book.BookBuilder.book;
import static com.moaa.domain.books.properties.Author.AuthorBuilder.author;
import static java.util.Collections.unmodifiableList;
import static org.assertj.core.api.Assertions.assertThat;

public class BookDatabaseTest {

    @Test
    public void getBooks_givenABookDatabase_thenReturnAnEmptyListOfBooks() {
        // given
        BookDatabase bookDatabase = new BookDatabase();
        List<Book> expectedResult = unmodifiableList(new ArrayList<>());

        // when
        List<Book> actualResult = bookDatabase.getBooks();

        // then
        assertThat(actualResult)
                .isEqualTo(expectedResult);
    }


    /*@Test
    public void createBook_givenABookToAdd_thenAddTheBookToTheListOfBooksAndReturnTheBook() {
        // given
        BookDatabase bookDatabase = new BookDatabase();
        Isbn isbn = Isbn.create();
        String title = "title of a book to add to the database";
        Author author = author()
                        .withFirstName("Jan")
                        .withLastName("Janssens")
                        .build();

        Book book = book()
                        .withIsbn(isbn)
                        .withTitle(title)
                        .withAuthor(author)
                        .build();

        Book expectedResult = book;

        // when
        Book actualResult = bookDatabase.createBook(book);

        // then
        assertThat(actualResult.getIsbn()).isEqualTo(expectedResult.getIsbn());
        assertThat(actualResult.getTitle()).isEqualTo(expectedResult.getTitle());
        assertThat(actualResult.getAuthor()).isEqualTo(expectedResult.getAuthor());
        assertThat(actualResult.getId()).isEqualTo(expectedResult.getId());

        assertThat(bookDatabase.getBooks().get(0).getIsbn()).isEqualTo(expectedResult.getIsbn());
        assertThat(bookDatabase.getBooks().get(0).getTitle()).isEqualTo(expectedResult.getTitle());
        assertThat(bookDatabase.getBooks().get(0).getAuthor()).isEqualTo(expectedResult.getAuthor());
        assertThat(bookDatabase.getBooks().get(0).getId()).isNotEqualTo(expectedResult.getId());

        assertThat(bookDatabase.getBooks()).hasSize(1);
    }*/

}

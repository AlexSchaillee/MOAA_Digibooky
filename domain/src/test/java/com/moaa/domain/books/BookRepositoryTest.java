/*
package com.moaa.domain.books;

import com.moaa.domain.books.databases.BookDatabase;
import com.moaa.domain.books.properties.Isbn;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static com.moaa.domain.books.properties.Author.AuthorBuilder.author;
import static com.moaa.domain.books.Book.BookBuilder.book;
import static java.util.Collections.unmodifiableList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookRepositoryTest {

    @Mock
    private BookDatabase bookDatabase;

    @InjectMocks
    private BookRepository bookRepository;

    public List<Book> populateBookDatabase() {
        Book book1 = book().withAuthor(author()
                .withFirstName("Jan1")
                .withLastName("Janssens1")
                .build())
                .withIsbn(Isbn.create())
                .withTitle("title 1")
                .build();
        Book book2 = book().withAuthor(author()
                .withFirstName("Jan2")
                .withLastName("Janssens2")
                .build())
                .withIsbn(Isbn.create())
                .withTitle("title 2")
                .build();
        Book book3 = book().withAuthor(author()
                .withFirstName("Jan3")
                .withLastName("Janssens3")
                .build())
                .withIsbn(Isbn.create())
                .withTitle("title 3")
                .build();
        return new ArrayList<>(Arrays.asList(book1, book2, book3));
    }

    @Test
    public void getBooks_givenAnEmptyDatabase() {
        List<Book> expectedBooks = unmodifiableList(new ArrayList<>());
        when(bookDatabase.getBooks())
                .thenReturn(expectedBooks);

        List<Book> actualBooks = bookRepository.getBooks();

        assertThat(actualBooks)
                .isEqualTo(expectedBooks);
    }

    @Test
    public void getBooks_givenANonEmptyDatabase() {
        List<Book> expectedBooks = populateBookDatabase();
        when(bookDatabase.getBooks())
                .thenReturn(expectedBooks);

        List<Book> actualBooks = bookRepository.getBooks();

        assertThat(actualBooks)
                .isEqualTo(expectedBooks);
    }

    @Test
    public void createBook_thenCallCreateBookInDatabaseAndReturnCreatedBook() {
        Book book = book()
                    .withAuthor(author()
                    .withFirstName("Jan10")
                    .withLastName("Janssens10")
                    .build())
                .withIsbn(Isbn.create())
                .withTitle("title 10")
                .build();
        when(bookDatabase.createBook(book.getIsbn(), book.getTitle(), book.getAuthor()))
                .thenReturn(book);

        assertThat(bookRepository.createBook(book.getIsbn(), book.getTitle(), book.getAuthor()))
            .isEqualTo(book);
    }

    */
/*@Test
    public void showDetailsOfBook_givenAPresentBookId_thenReturnTheDetailsOfTheBook() {
        List<Book> listOfBooksInDatabase = populateBookDatabase();
        when(bookDatabase.getBooks()).thenReturn(listOfBooksInDatabase);
        Book expectedBook = listOfBooksInDatabase.get(0);
        String expectedDetailsOfBook = expectedBook.getIsbn() + "\n" + expectedBook.getTitle() + "\n" +
                                        expectedBook.getAuthor().getFirstName() + " " + expectedBook.getAuthor().getLastName();
        String actualDetailsOfBook = bookRepository.showDetailsOfBook(listOfBooksInDatabase.get(0).getIsbn());
        assertThat(actualDetailsOfBook)
                .isEqualTo(expectedDetailsOfBook);
    }

    @Test
    public void showDetailsOfBook_givenANonPresentBookId_thenThrowException() {
        List<Book> listOfBooksInDatabase = populateBookDatabase();
        when(bookDatabase.getBooks()).thenReturn(listOfBooksInDatabase);
        Book expectedBook = book().withAuthor(author()
                .withFirstName("Jan5")
                .withLastName("Janssens5")
                .build())
                .withIsbn(Isbn.create())
                .withTitle("title 5")
                .build();
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(()->bookRepository.showDetailsOfBook(expectedBook.getIsbn()))
                .withMessage("No value present");
    }*//*


}*/

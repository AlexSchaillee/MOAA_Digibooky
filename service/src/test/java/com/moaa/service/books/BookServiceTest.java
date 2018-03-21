/*
package com.moaa.service.books;

import com.moaa.domain.books.properties.Author;
import com.moaa.domain.books.Book;
import com.moaa.domain.books.BookRepository;
import com.moaa.domain.books.properties.Isbn;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.moaa.domain.books.Book.BookBuilder.book;
import static com.moaa.domain.books.properties.Author.AuthorBuilder.author;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    public List<Book> populateBookDatabase() {
        Book book1 = book()
                .withAuthor(author()
                            .withFirstName("Jan1")
                            .withLastName("Janssens1")
                            .build())
                .withIsbn(Isbn.create())
                .withTitle("title 1")
                .build();
        Book book2 = book()
                .withAuthor(author()
                        .withFirstName("Jan2")
                        .withLastName("Janssens2")
                        .build())
                .withIsbn(Isbn.create())
                .withTitle("title 2")
                .build();
        Book book3 = book()
                .withAuthor(author()
                        .withFirstName("Jan3")
                        .withLastName("Janssens3")
                        .build())
                .withIsbn(Isbn.create())
                .withTitle("title 3")
                .build();

        return new ArrayList<>(Arrays.asList(book1, book2, book3));
    }

    @Test
    public void getBooks_givenAnEmptyBookDatabase_thenReturnAnEmptyArrayList(){
        List<Book> expectedResult = new ArrayList<>();
        Mockito.when(bookRepository.getBooks())
                .thenReturn(Collections.unmodifiableList(new ArrayList<>()));

        List<Book> actualResult = bookService.getBooks();

        assertThat(actualResult)
                .isEqualTo(expectedResult);
    }

    @Test
    public void getBooks_givenAnNonEmptyBookDatabase_thenReturnTheListOfBooks(){
        List<Book> expectedResult = populateBookDatabase();
        Mockito.when(bookRepository.getBooks())
                .thenReturn(expectedResult);

        List<Book> actualResult = bookService.getBooks();

        assertThat(actualResult)
                .isEqualTo(expectedResult);
    }

    @Test
    public void createBook_thenCallCreateBookInRepositoryAndReturnCreatedBook() {
        Book book = book()
                .withAuthor(author()
                        .withFirstName("Jan10")
                        .withLastName("Janssens10")
                        .build())
                .withIsbn(Isbn.create())
                .withTitle("title 10")
                .build();
        when(bookRepository.createBook(book.getIsbn(), book.getTitle(), book.getAuthor()))
                .thenReturn(book);

        assertThat(bookService.createBook(book.getIsbn(), book.getTitle(), book.getAuthor()))
                .isEqualTo(book);
    }

    */
/*@Test
    public void showDetailsOfBook_givenAPresentBookId_thenReturnTheDetailsOfTheBook() {
        List<Book> listOfBooksInDatabase = populateBookDatabase();
        Mockito.when(bookRepository.showDetailsOfBook(listOfBooksInDatabase.get(0).getId()))
                .thenReturn("isbn1\ntitle 1\nJan1 Janssens1");
        Book expectedBook = listOfBooksInDatabase.get(0);
        String expectedDetailsOfBook = expectedBook.getIsbn() + "\n" + expectedBook.getTitle() + "\n" +
                expectedBook.getAuthor().getFirstName() + " " + expectedBook.getAuthor().getLastName();
        String actualDetailsOfBook = bookService.showDetailsOfBook(listOfBooksInDatabase.get(0).getId());
        assertThat(actualDetailsOfBook)
                .isEqualTo(expectedDetailsOfBook);
    }*//*


}
*/

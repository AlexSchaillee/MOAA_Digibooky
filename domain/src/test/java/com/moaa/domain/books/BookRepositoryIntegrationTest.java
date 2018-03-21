package com.moaa.domain.books;

import com.moaa.domain.books.properties.Isbn;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.moaa.domain.books.Book.BookBuilder.book;
import static com.moaa.domain.books.properties.Author.AuthorBuilder.author;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.SpringApplication.run;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookRepositoryIntegrationTest.BookRepositoryIntegrationTestRunner.class)
public class BookRepositoryIntegrationTest {

    @Inject
    private BookRepository bookRepository;

    private List<Book> populateBookDatabase() {
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
    public void getBooks_givenAnEmptyDatabase_thenReturnAnEmptyArrayList() {
        // given
        // empty database injected into bookRepository
        bookRepository.clearDatabase();

        // when
        List<Book> actualResult = bookRepository.getBooks();

        // then
        assertThat(actualResult)
                .isEmpty();

    }


    @Test
    public void getBooks_givenANonEmptyDatabase_thenReturnTheListOfBooks() {
        // given
        bookRepository.clearDatabase();
        Book book1 = bookRepository.createBook(populateBookDatabase().get(0));
        Book book2 = bookRepository.createBook(populateBookDatabase().get(1));

        // when
        List<Book> actualResult = bookRepository.getBooks();

        // then
        assertThat(actualResult)
                .contains(book1,book2);

    }

    /*
    @Test
    public void createBook_givenAnIsbnAndATitleAndAnAuthor_thenAddTheBookToTheDatabaseAndReturnTheBook() {
        Book book = bookRepository.createBook(Isbn.create(), "title 1", author()
                .withFirstName("Jan1")
                .withLastName("Janssens1")
                .build());
        assertThat(bookRepository.getBooks())
                .containsExactly(book);
    }

    @Test
    public void showDetailsOfBook_givenAPresentBookId_thenReturnTheDetailsOfTheBook() {
        Book book = book().withAuthor(author()
                .withFirstName("Jan1")
                .withLastName("Janssens1")
                .build())
                .withIsbn(Isbn.create())
                .withTitle("title 1")
                .build();
        Book book1 = bookRepository.createBook(book.getIsbn(), book.getTitle(), book.getAuthor());
        String expectedDetailsOfBook = book.getIsbn() + "\n" + book.getTitle() + "\n" +
                book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName();
        String actualDetailsOfBook = bookRepository.showDetailsOfBook(book1.getIsbn());
        assertThat(actualDetailsOfBook)
                .isEqualTo(expectedDetailsOfBook);
    }

    @Test
    public void showDetailsOfBook_givenANonPresentBookId_thenThrowException() {
        Book book = book().withAuthor(author()
                .withFirstName("Jan1")
                .withLastName("Janssens1")
                .build())
                .withIsbn(Isbn.create())
                .withTitle("title 1")
                .build();
        Book book1 = bookRepository.createBook(book.getIsbn(), book.getTitle(), book.getAuthor());
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(()->bookRepository.showDetailsOfBook(book.getIsbn()))
                .withMessage("No value present");
    }

    */
    @SpringBootApplication(scanBasePackageClasses = BookRepository.class)
    public static class BookRepositoryIntegrationTestRunner {

        public static void main(String[] args) {
            run(BookRepositoryIntegrationTestRunner.class, args);
        }
    }

}

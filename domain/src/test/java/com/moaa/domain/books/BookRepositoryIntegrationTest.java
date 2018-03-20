package com.moaa.domain.books;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static com.moaa.domain.books.Book.BookBuilder.book;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;
import static org.springframework.boot.SpringApplication.run;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookRepositoryIntegrationTest.BookRepositoryIntegrationTestRunner.class)
public class BookRepositoryIntegrationTest {

    @Inject
    private BookRepository bookRepository;

    public List<Book> populateBookDatabase() {
        Book book1 = book().withAuthor(Author.AuthorBuilder.author()
                .withFirstName("Jan1")
                .withLastName("Janssens1")
                .build())
                .withIsbn("isbn1")
                .withTitle("title 1")
                .build();
        Book book2 = book().withAuthor(Author.AuthorBuilder.author()
                .withFirstName("Jan2")
                .withLastName("Janssens2")
                .build())
                .withIsbn("isbn2")
                .withTitle("title 2")
                .build();
        Book book3 = book().withAuthor(Author.AuthorBuilder.author()
                .withFirstName("Jan3")
                .withLastName("Janssens3")
                .build())
                .withIsbn("isbn3")
                .withTitle("title 3")
                .build();
        List<Book> listOfBooks = new ArrayList<>(Arrays.asList(book1, book2, book3));
        return listOfBooks;
    }

    @Test
    public void createBook_givenAnIsbnAndATitleAndAnAuthor_thenAddTheBookToTheDatabaseAndReturnTheBook() {
        Book book = bookRepository.createBook("isbn1", "title 1", Author.AuthorBuilder.author()
                .withFirstName("Jan1")
                .withLastName("Janssens1")
                .build());
        assertThat(bookRepository.getBooks())
                .containsExactly(book);
    }

    @Test
    public void showDetailsOfBook_givenAPresentBookId_thenReturnTheDetailsOfTheBook() {
        Book book = book().withAuthor(Author.AuthorBuilder.author()
                .withFirstName("Jan1")
                .withLastName("Janssens1")
                .build())
                .withIsbn("isbn1")
                .withTitle("title 1")
                .build();
        Book book1 = bookRepository.createBook(book.getIsbn(), book.getTitle(), book.getAuthor());
        String expectedDetailsOfBook = book.getIsbn() + "\n" + book.getTitle() + "\n" +
                book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName();
        String actualDetailsOfBook = bookRepository.showDetailsOfBook(book1.getId());
        assertThat(actualDetailsOfBook)
                .isEqualTo(expectedDetailsOfBook);
    }

    @Test
    public void showDetailsOfBook_givenANonPresentBookId_thenThrowException() {
        Book book = book().withAuthor(Author.AuthorBuilder.author()
                .withFirstName("Jan1")
                .withLastName("Janssens1")
                .build())
                .withIsbn("isbn1")
                .withTitle("title 1")
                .build();
        Book book1 = bookRepository.createBook(book.getIsbn(), book.getTitle(), book.getAuthor());
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(()->bookRepository.showDetailsOfBook(book.getId()))
                .withMessage("No value present");
    }

    @SpringBootApplication
    public static class BookRepositoryIntegrationTestRunner {

        public static void main(String[] args) {
            run(BookRepositoryIntegrationTestRunner.class, args);
        }
    }

}
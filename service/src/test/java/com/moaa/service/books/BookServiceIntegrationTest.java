package com.moaa.service.books;

import com.moaa.domain.books.Book;
import com.moaa.domain.books.BookRepository;
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
@SpringBootTest(classes = BookServiceIntegrationTest.BookServiceIntegrationTestRunner.class)
public class BookServiceIntegrationTest {

    @Inject
    private BookService bookService;

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
    public void getBooks_givenAnEmptyBookDatabase_thenReturnAnEmptyArrayList(){
        // given
        bookService.clearDatabase();
        List<Book> expectedResult = new ArrayList<>();

        // when
        List<Book> actualResult = bookService.getBooks();

        // then
        assertThat(actualResult)
                .isEqualTo(expectedResult);
    }

    @Test
    public void getBooks_givenAnNonEmptyBookDatabase_thenReturnTheListOfBooks(){
        // given
        bookService.clearDatabase();
        Book book1 = bookService.createBook(populateBookDatabase().get(0));
        Book book2 = bookService.createBook(populateBookDatabase().get(1));

        // when
        List<Book> actualResult = bookService.getBooks();

        // then
        assertThat(actualResult)
                .contains(book1,book2);
    }

    @SpringBootApplication(scanBasePackageClasses = {BookService.class, BookRepository.class})
    public static class BookServiceIntegrationTestRunner {

        public static void main(String[] args) {
            run(BookServiceIntegrationTestRunner.class, args);
        }
    }

}

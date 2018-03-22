package com.moaa.api.books;

import com.moaa.api.member.MemberMapper;
import com.moaa.domain.books.Book;
import com.moaa.domain.books.BookRepository;
import com.moaa.domain.books.properties.Isbn;
import com.moaa.domain.lending.LendRepository;
import com.moaa.domain.member.MemberRepository;
import com.moaa.service.books.BookService;
import com.moaa.service.lending.LendService;
import com.moaa.service.member.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.moaa.domain.books.Book.BookBuilder.book;
import static com.moaa.domain.books.properties.Author.AuthorBuilder.author;
import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.SpringApplication.run;

// copied code from funiversity example

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookControllerIntegrationTest.BookControllerIntegrationTestRunner.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Inject
    private BookService bookService;
    @Inject
    private BookMapper bookMapper;

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
    public void getBooks_givenAnEmptyDatabase_thenReturnAnEmptyArrayList(){
        // given
        bookService.clearDatabase();

        //when
        BookDto[] bookDtos = new TestRestTemplate()
                .getForObject(format("http://localhost:%s/%s", port, "books"), BookDto[].class);

        //then
        assertThat(bookDtos).isEmpty();
    }

    @Test
    public void getBooks_givenANonEmptyDatabase_thenReturnTheListOfBooks(){

        bookService.clearDatabase();

        bookService.createBook(populateBookDatabase().get(0));
        bookService.createBook(populateBookDatabase().get(1));

        BookDto[] bookDtos = new TestRestTemplate()
                .getForObject(format("http://localhost:%s/%s", port, "books"), BookDto[].class);

        assertThat(bookDtos).hasSize(2);
    }


    @SpringBootApplication(scanBasePackageClasses = {BookMapper.class, BookService.class, BookRepository.class
                                                    , LendService.class, LendRepository.class, MemberService.class
                                                    , MemberRepository.class, MemberMapper.class})
    public static class BookControllerIntegrationTestRunner {

        public static void main(String[] args) {
            run(BookControllerIntegrationTestRunner.class, args);
        }
    }

}

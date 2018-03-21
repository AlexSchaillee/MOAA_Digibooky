package com.moaa.service.books;

import com.moaa.domain.books.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.SpringApplication.run;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookServiceIntegrationTest.BookServiceIntegrationTestRunner.class)
public class BookServiceIntegrationTest {

    @Inject
    private BookService bookService;

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

    @SpringBootApplication(scanBasePackages= {"com.moaa"})
    public static class BookServiceIntegrationTestRunner {

        public static void main(String[] args) {
            run(BookServiceIntegrationTestRunner.class, args);
        }
    }

}

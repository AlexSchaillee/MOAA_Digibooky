package com.moaa.domain.books;

import com.moaa.domain.books.properties.Isbn;
import org.junit.Test;

import static com.moaa.domain.books.properties.Author.AuthorBuilder.author;
import static com.moaa.domain.books.Book.BookBuilder.book;

public class BookTest {

    @Test
    public void toString_thenReturnTheDetailsOfTheBook() {
        String isbn = Isbn.create(1).toString();
        Book book = book().withAuthor(author()
                        .withFirstName("Jan1")
                        .withLastName("Janssens1")
                        .build())
                .withIsbn(Isbn.create(1))
                .withTitle("title 1")
                .build();
        String expectedString = isbn + "\ntitle 1\nJan1 Janssens1";
        String actualString = book.toString();
        org.assertj.core.api.Assertions
                .assertThat(actualString).isEqualTo(expectedString);

    }

}
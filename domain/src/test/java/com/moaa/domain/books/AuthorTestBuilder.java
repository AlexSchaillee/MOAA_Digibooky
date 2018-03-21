package com.moaa.domain.books;

import com.moaa.domain.books.properties.Author;

import static com.moaa.domain.books.properties.Author.AuthorBuilder.author;
import static org.assertj.core.api.Assertions.assertThat;

// used example code funiversity
public class AuthorTestBuilder {

    private String firstName;
    private String lastName;

    private AuthorTestBuilder() {
        firstName = "Jan";
        lastName = "Janssens";
    }

    public static AuthorTestBuilder aAuthor() {
        return new AuthorTestBuilder();
    }

    public Author build() {
        return author()
                .withFirstName(firstName)
                .withLastName(lastName)
                .build();
    }

    public AuthorTestBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public AuthorTestBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
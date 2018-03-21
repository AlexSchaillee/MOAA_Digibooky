package com.moaa.domain.books.properties;

import java.util.Objects;

// used example code funiversity
public class Author {

    private String firstName;
    private String lastName;

    private Author() { }

    Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(firstName, author.firstName) &&
                Objects.equals(lastName, author.lastName);
    }

    @Override
    public int hashCode() { return Objects.hash(firstName, lastName); }

    public static class AuthorBuilder {
        private String firstName;
        private String lastName;

        private AuthorBuilder(){}

        public static AuthorBuilder author() {
            return new AuthorBuilder();
        }

        public Author build() {
            Author author = new Author();
            author.setFirstName(firstName);
            author.setLastName(lastName);
            return author;
        }

        public AuthorBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public AuthorBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
    }
}

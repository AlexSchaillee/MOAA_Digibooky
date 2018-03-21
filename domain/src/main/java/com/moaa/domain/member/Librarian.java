package com.moaa.domain.member;

import com.moaa.domain.member.email.Email;

import java.util.UUID;

public class Librarian {

    private UUID id;
    private String firstName;
    private String lastName;
    private Email email;

    Librarian(String firstName, String lastName, Email email) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Email getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email=" + email +
                '}';
    }

    public static class LibrarianBuilder {
        private String firstName;
        private String lastName;
        private Email email;

        public static LibrarianBuilder librarianBuilder(){
        return new LibrarianBuilder();
        }

        public LibrarianBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public LibrarianBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public LibrarianBuilder withEmail(Email email) {
            this.email = email;
            return this;
        }

        public Librarian createLibrarian() {
            return new Librarian(firstName, lastName, email);
        }


    }
}

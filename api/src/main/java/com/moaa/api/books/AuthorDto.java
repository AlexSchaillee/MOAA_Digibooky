package com.moaa.api.books;

import java.util.Objects;

public class AuthorDto {

    private String firstName;
    private String lastName;

    public static AuthorDto authorDto(){
        return new AuthorDto();
    }

    public AuthorDto withFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public AuthorDto withLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorDto authorDto = (AuthorDto) o;
        return Objects.equals(firstName, authorDto.firstName) &&
                Objects.equals(lastName, authorDto.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName);
    }
}

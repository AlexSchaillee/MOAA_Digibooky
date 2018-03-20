package com.moaa.api.books;

import javax.inject.Named;

public class AuthorDto {

    private String firstName;
    private String lastName;

    public static AuthorDto authorDto(){
        return new AuthorDto();
    }

    public AuthorDto withFirstname(String firstName){
        this.firstName = firstName;
        return this;
    }

    public AuthorDto withLastname(String lastName){
        this.lastName = lastName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

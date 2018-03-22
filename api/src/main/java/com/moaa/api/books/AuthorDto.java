package com.moaa.api.books;

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
}

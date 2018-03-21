package com.moaa.api.member;

import com.moaa.domain.member.Librarian;

public class LibrarianDTO {

   /* private String id;*/
    private String firstName;
    private String lastName;
    private String email;

    public static LibrarianDTO librarianDTO(){
        return new LibrarianDTO();
    }
/*
    public LibrarianDTO withId(String id){
        this.id = id;
        return this;
    }*/

    public LibrarianDTO withFirstname(String firstName){
        this.firstName = firstName;
        return this;
    }

    public LibrarianDTO withLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public LibrarianDTO withEmail(String email){
        this.email = email;
        return this;
    }
/*
    public String getId() {
        return id;
    }*/

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}

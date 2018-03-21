package com.moaa.api.books;

public class IsbnDto {

    private String isbnNumber;

    public static IsbnDto isbnDto(){
        return new IsbnDto();
    }

    public IsbnDto withIsbnNumber(String isbnNumber){
        this.isbnNumber = isbnNumber;
        return this;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }
}

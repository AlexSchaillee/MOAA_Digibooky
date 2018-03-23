package com.moaa.api.books;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IsbnDto isbnDto = (IsbnDto) o;
        return Objects.equals(isbnNumber, isbnDto.isbnNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(isbnNumber);
    }
}

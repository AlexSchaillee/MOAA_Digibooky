package com.moaa.api.books;

import com.moaa.domain.books.properties.Isbn;

import javax.inject.Named;

@Named
public class IsbnMapper {

    IsbnDto toDto(Isbn isbn){
        return IsbnDto.isbnDto()
                .withIsbnNumber(isbn.getIsbnNumber());
    }

    Isbn toDomain(IsbnDto isbnDto){
        return Isbn.convertStringToIsbn(isbnDto.getIsbnNumber());

    }

}

package com.moaa.api.books;

import com.moaa.domain.books.properties.Author;

import javax.inject.Named;

import static com.moaa.api.books.AuthorDto.authorDto;
import static com.moaa.domain.books.properties.Author.AuthorBuilder.author;

@Named
public class AuthorMapper {

    AuthorDto toDto(Author author){
        return authorDto()
                .withFirstName(author.getFirstName())
                .withLastName(author.getLastName());
    }

    Author toDomain(AuthorDto authorDto){
        return author()
                .withFirstName(authorDto.getFirstName())
                .withLastName(authorDto.getLastName())
                .build();
    }
}

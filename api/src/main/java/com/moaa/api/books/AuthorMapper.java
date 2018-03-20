package com.moaa.api.books;

import com.moaa.domain.books.Author;

import static com.moaa.domain.books.Author.AuthorBuilder.author;

public class AuthorMapper {

    AuthorDto toDto(Author author){
        return AuthorDto.authorDto()
                .withFirstname(author.getFirstName())
                .withLastname(author.getLastName());
    }

    Author toDomain(AuthorDto authorDto){
        return author()
                .withFirstName(authorDto.getFirstName())
                .withLastName(authorDto.getLastName())
                .build();
    }
}

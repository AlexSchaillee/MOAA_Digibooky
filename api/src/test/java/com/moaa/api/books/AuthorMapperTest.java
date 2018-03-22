package com.moaa.api.books;

import com.moaa.domain.books.properties.Author;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static com.moaa.domain.books.properties.Author.AuthorBuilder.author;

public class AuthorMapperTest {

    private AuthorMapper authorMapper;

    @Before
    public void instantiateMapper(){
        authorMapper = new AuthorMapper();
    }

    @Test
    public void toDto() {
        Author author = author()
                            .withFirstName("John")
                            .withLastName("Doe")
                            .build();

        AuthorDto authorDto = authorMapper.toDto(author);

        Assertions.assertThat(authorDto).isEqualToComparingFieldByField(author);
    }

    @Test
    public void toDomain() {
        AuthorDto authorDto = AuthorDto.authorDto()
                                .withFirstName("John")
                                .withLastName("Doe");

        Author author = authorMapper.toDomain(authorDto);

        Assertions.assertThat(author).isEqualToComparingFieldByField(authorDto);
    }
}
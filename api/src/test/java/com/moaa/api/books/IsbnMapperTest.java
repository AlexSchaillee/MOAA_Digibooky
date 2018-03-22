package com.moaa.api.books;

import com.moaa.domain.books.properties.Isbn;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class IsbnMapperTest {

    private IsbnMapper isbnMapper;

    @Before
    public void instantiateMapper(){
        isbnMapper = new IsbnMapper();
    }

    @Test
    public void toDto_givenIsbn_thenMapAllFieldsToIsbnDto() {
        Isbn isbn = Isbn.convertStringToIsbn("111-1-11-111111-1");

        IsbnDto isbnDto = isbnMapper.toDto(isbn);

        Assertions.assertThat(isbnDto).isEqualToComparingFieldByField(isbn);
    }

    @Test
    public void toDomain_givenIsbnDto_thenMapAllFieldsToIsbn() {
        IsbnDto isbnDto = IsbnDto.isbnDto()
                                    .withIsbnNumber("111-1-11-111111-1");

        Isbn isbn = isbnMapper.toDomain(isbnDto);

        Assertions.assertThat(isbn).isEqualToComparingFieldByField(isbnDto);
    }
}
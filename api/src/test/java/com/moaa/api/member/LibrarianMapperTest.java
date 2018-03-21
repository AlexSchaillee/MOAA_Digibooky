package com.moaa.api.member;

import com.moaa.domain.member.Librarian;
import com.moaa.domain.member.email.Email;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import static com.moaa.domain.member.Librarian.LibrarianBuilder.librarianBuilder;

public class LibrarianMapperTest {

    private LibrarianMapper librarianMapper;

    @Before
    public void instantiateMapper(){
        librarianMapper = new LibrarianMapper();
    }

    @Test
    public void toDto_givenLibrarian_thenMapAllFieldsToLibrarianDto() {
        Librarian librarian = librarianBuilder()
                .withFirstName("Alex")
                .withLastName("Schaillée")
                .withEmail(Email.of("alex.Schaillee@cm.be"))
                .createLibrarian();

        LibrarianDTO librarianDTO = librarianMapper.toDto(librarian);

        assertThat(librarianDTO.getFirstName())
                .isEqualTo(librarian.getFirstName());

        assertThat(librarianDTO.getLastName())
                .isEqualTo(librarian.getLastName());

        assertThat(librarianDTO.getEmail())
                .isEqualTo(librarian.getEmail().toString());
    }

    @Test
    public void toDomain_givenLibrarianDto_thenMapAllFieldsToLibrarian() {
        LibrarianDTO librarianDTO = LibrarianDTO.librarianDTO()
                .withFirstname("Alex")
                .withLastName("Schaillee")
                .withEmail("alex.schaillee@cm.be");

        Librarian librarian = librarianMapper.toDomain(librarianDTO);

        assertThat(librarian.getFirstName())
                .isEqualTo(librarianDTO.getFirstName());

        assertThat(librarian.getLastName())
                .isEqualTo(librarianDTO.getLastName());

        assertThat(librarian.getEmail().toString())
                .isEqualTo(librarianDTO.getEmail());
    }
}
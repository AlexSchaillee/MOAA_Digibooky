package com.moaa.api.member;

import com.moaa.domain.member.Librarian;
import com.moaa.domain.member.email.Email;

import javax.inject.Named;

import static com.moaa.domain.member.Librarian.LibrarianBuilder.librarianBuilder;

@Named
public class LibrarianMapper {

    LibrarianDTO toDto(Librarian librarian) {
        return LibrarianDTO.librarianDTO()
                .withFirstname(librarian.getFirstName())
                .withLastName(librarian.getLastName())
                .withEmail(librarian.getEmail().toString());
    }

    Librarian toDomain(LibrarianDTO librarianDTO) {
        return librarianBuilder()
                .withFirstName(librarianDTO.getFirstName())
                .withLastName(librarianDTO.getLastName())
                .withEmail(Email.of(librarianDTO.getEmail()))
                .createLibrarian();
    }
}

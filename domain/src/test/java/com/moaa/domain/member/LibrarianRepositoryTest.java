package com.moaa.domain.member;

import com.moaa.domain.member.databases.LibrarianDataBase;
import com.moaa.domain.member.email.Email;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class LibrarianRepositoryTest {

    @Mock
    private LibrarianDataBase librarianDataBase;

    @InjectMocks
    private LibrarianRepository librarianRepository;

    @Test
    public void integrationTest_addLibrarian_GivenALibrarian_AddToLibrarianList() {
        //GIVEN
        Librarian librarian = Librarian.LibrarianBuilder.librarianBuilder()
                .withFirstName("Alex")
                .withLastName("Schaillée")
                .withEmail(Email.of("alex.schaillee@cm.be"))
                .createLibrarian();
        //WHEN
        Mockito.when(librarianDataBase.getLibrarianList())
                .thenReturn(Arrays.asList(librarian));

        librarianRepository.createLibrarian(librarian);
        //THEN
        Assertions.assertThat((librarianDataBase.getLibrarianList()).contains(librarian));
    }
}
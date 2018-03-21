package com.moaa.service.member;

import com.moaa.domain.member.Librarian;
import com.moaa.domain.member.LibrarianRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class LibrarianService {

    private final LibrarianRepository librarianRepository;

    @Inject
    public LibrarianService(LibrarianRepository librarianRepository) {
        this.librarianRepository = librarianRepository;
    }

    public Librarian createLibrarian (Librarian librarian){
        return librarianRepository.createLibrarian(librarian);
    }

}




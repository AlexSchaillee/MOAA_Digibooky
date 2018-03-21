package com.moaa.api.member;

import com.moaa.domain.member.Librarian;
import com.moaa.service.member.LibrarianService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = {"/librarian"})
public class LibrarianController {

    private LibrarianService librarianService;
    private LibrarianMapper librarianMapper;

    @Inject
    public LibrarianController(LibrarianService librarianService, LibrarianMapper librarianMapper) {
        this.librarianService = librarianService;
        this.librarianMapper = librarianMapper;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public LibrarianDTO registerLibrarian (@RequestBody Librarian librarian){
        return librarianMapper.toDto(librarianService.createLibrarian(librarian));
    }
}

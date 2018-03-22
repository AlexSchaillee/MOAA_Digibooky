package com.moaa.api.lending;

import com.moaa.api.books.BookDto;
import com.moaa.api.books.BookMapper;
import com.moaa.domain.books.Book;
import com.moaa.service.lending.LendService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/renting")
public class LendContractController {

    private LendService lendService;
    private LendContractMapper lendContractMapper;
    @Inject
    private BookMapper bookMapper;

    @Inject
    public LendContractController(LendService lendService, LendContractMapper lendContractMapper) {
        this.lendService = lendService;
        this.lendContractMapper = lendContractMapper;
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public LendContractDto lendContractDto(@RequestParam("memberId") String memberId, @RequestParam("bookIsbn") String bookIsbn) {
        return lendContractMapper.toDto(lendService.addLendContract(memberId, bookIsbn));
    }

    @PutMapping(path = "/return", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String deleteLendContract(@RequestParam("lendId") Integer lendId) {
        return lendService.removeContract(lendId);
    }

    @GetMapping(path = "/user", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getBooksLentByMember(@RequestParam("memberId") String memberId){
        return lendService.getBooksLentByMember(memberId).stream()
                .map(e->bookMapper.toDto(e))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/overduebooks", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getAllOverdueBooks(){
        return lendService.getAllOverdueBooks().stream()
                .map(e->bookMapper.toDto(e))
                .collect(Collectors.toList());
    }


}

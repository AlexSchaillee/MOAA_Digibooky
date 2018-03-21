package com.moaa.api.lending;

import com.moaa.service.lending.LendService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.inject.Inject;

@RestController
@RequestMapping(path = {"/renting"})
public class LendContractController {

    private LendService lendService;
    private LendContractMapper lendContractMapper;

    @Inject
    public LendContractController(LendService lendService, LendContractMapper lendContractMapper) {
        this.lendService = lendService;
        this.lendContractMapper = lendContractMapper;
    }

    @PostMapping(path="/{memberId}/{bookIsbn}" , produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public LendContractDto lendContractDto(@PathVariable("memberId") String memberId, @PathVariable("bookIsbn")String bookIsbn){
        return lendContractMapper.toDto(lendService.addLendContract(memberId, bookIsbn));
    }
}

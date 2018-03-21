package com.moaa.service.lending;

import com.moaa.domain.lending.LendContract;
import com.moaa.domain.lending.LendRepository;
import com.moaa.service.books.BookService;
import com.moaa.service.member.MemberService;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class LendService {

    private final LendRepository lendRepository;
    private final BookService bookService;
    private final MemberService memberService;

    @Inject
    public LendService(LendRepository lendRepository, BookService bookService, MemberService memberService) {
        this.lendRepository = lendRepository;
        this.bookService = bookService;
        this.memberService = memberService;
    }

    public LendContract addLendContract(String memberId, String bookIsbn) throws IllegalArgumentException {
        if (bookService.getBooksByIsbn(bookIsbn).size()>1){
            throw new IllegalArgumentException
                    ("Please provide a unique Isbn. More than one book found for isbn-part: "+bookIsbn);
        }
        return lendRepository.addLendContract(
                LendContract.LendContractBuilder.lendContract()
                .withBook(bookService.getBooksByIsbn(bookIsbn).get(0))
                .withMember(memberService.getMemberById(memberId))
                .build());

    }
}

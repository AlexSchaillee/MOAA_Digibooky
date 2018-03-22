package com.moaa.service.lending;

import com.moaa.domain.books.Book;
import com.moaa.domain.lending.LendContract;
import com.moaa.domain.lending.LendRepository;
import com.moaa.domain.member.Member;
import com.moaa.service.books.BookService;
import com.moaa.service.member.MemberService;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

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

    public String removeContract(Integer lendId) throws IllegalArgumentException {
        return getOverdueMessage(lendRepository.removeContract(
                lendRepository.getLendContractList().stream()
                        .filter(e -> lendId.equals(e.getLendId()))
                        .findFirst()
                        .orElse(null)));
    }

    private String getOverdueMessage(LendContract lendContract) {
        String message = "Thx for returning your book in time";
        if (LocalDate.now().isAfter(lendContract.getDueDate())) {
            message = "Your book is "
                    + DAYS.between(lendContract.getDueDate(), LocalDate.now())
                    + " days overdue";
        }

        return message;
    }

    public List<Book> getBooksLentByMember(String memberId) {
        return lendRepository.getLendContractList().stream()
                .filter(e->memberId.equals(e.getMember().getId().toString()))
                .map(LendContract::getBook)
                .collect(Collectors.toList());
    }

    // copy of getBooksLentByMember
    public List<Member> getBorrowerOfBook(String isbn) {
        return lendRepository.getLendContractList().stream()
                .filter(lendContract->lendContract.getBook().getIsbn().getIsbnNumber().equals(isbn))
                .map(LendContract::getMember)
                .collect(Collectors.toList());
    }

    public List<Book> getAllOverdueBooks() {
        return lendRepository.getLendContractList().stream()
                .filter(e->LocalDate.now().isAfter(e.getDueDate()))
                .map(LendContract::getBook)
                .collect(Collectors.toList());
    }
}

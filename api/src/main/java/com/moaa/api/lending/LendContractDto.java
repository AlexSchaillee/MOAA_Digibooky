package com.moaa.api.lending;

import com.moaa.api.books.BookDto;
import com.moaa.api.member.MemberDTO;
import com.moaa.domain.member.Member;

import java.time.LocalDate;

public class LendContractDto {
    private MemberDTO member;
    private BookDto book;
    private LocalDate dueDate;
    private Integer lendId;

    private LendContractDto() {
    }

    public static LendContractDto lendContractDto() {
        return new LendContractDto();
    }

    public LendContractDto withMember(MemberDTO member) {
        this.member = member;
        return this;
    }

    public LendContractDto withBook(BookDto book) {
        this.book = book;
        return this;
    }

    public LendContractDto withDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public LendContractDto withLendId(Integer lendId) {
        this.lendId = lendId;
        return this;
    }

    public MemberDTO getMember() {
        return member;
    }

    public BookDto getBook() {
        return book;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Integer getLendId() {
        return lendId;
    }
}

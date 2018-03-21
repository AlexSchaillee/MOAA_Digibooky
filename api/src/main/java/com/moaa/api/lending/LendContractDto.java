package com.moaa.api.lending;

import com.moaa.domain.books.Book;
import com.moaa.domain.member.Member;

import java.time.LocalDate;

public class LendContractDto {
    private Member member;
    private Book book;
    private LocalDate dueDate;
    private Integer lendId;

    private LendContractDto() {
    }

    public static LendContractDto lendContractDto() {
        return new LendContractDto();
    }

    public LendContractDto withMember(Member member) {
        this.member = member;
        return this;
    }

    public LendContractDto withBook(Book book) {
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

    public Member getMember() {
        return member;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Integer getLendId() {
        return lendId;
    }
}

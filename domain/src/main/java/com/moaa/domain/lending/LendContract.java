package com.moaa.domain.lending;

import com.moaa.domain.books.Book;
import com.moaa.domain.member.Member;

import java.time.LocalDate;

public class LendContract {

    private static int lendContractCounter = 0;
    private static final long standardLendingDays = 21;

    private Member member;
    private Book book;
    private LocalDate dueDate;
    private Integer lendId;

    private LendContract(Member member, Book book, LocalDate dueDate) {
        this.member = member;
        this.book = book;
        this.dueDate = dueDate;
        this.lendId = lendContractCounter++;
    }

    public Member getMember() {
        return member;
    }

    public Book getBook() {
        return book;
    }

    public Integer getLendId() {
        return lendId;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public static class LendContractBuilder {
        private Member member;
        private Book book;
        private LocalDate dueDate;

        public static LendContractBuilder lendContract() {
            return new LendContractBuilder();
        }

        public LendContractBuilder withMember(Member member) {
            this.member = member;
            return this;
        }

        public LendContractBuilder withBook(Book book) {
            this.book = book;
            if (book.getLendingPeriodInDays() == null) {
                this.dueDate = LocalDate.now().plusDays(standardLendingDays);
            } else {
                this.dueDate = LocalDate.now().plusDays(book.getLendingPeriodInDays());
            }
            return this;
        }

        public LendContract build(){
            return new LendContract(member, book, dueDate);
        }

    }
}

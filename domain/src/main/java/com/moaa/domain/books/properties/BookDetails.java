package com.moaa.domain.books.properties;

import com.moaa.domain.books.Book;
import com.moaa.domain.member.Member;

public class BookDetails {

    private Book book;
    private Member borrower;

    public BookDetails(Book book, Member borrower) {
        this.book = book;
        this.borrower = borrower;
    }

    public Book getBook() {
        return book;
    }

    public Member getBorrower() {
        return borrower;
    }

    @Override
    public String toString() {
        return book.toString() + borrower.toString();
    }
}

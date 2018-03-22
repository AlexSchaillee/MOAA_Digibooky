package com.moaa.domain.lending.databases;

import com.moaa.domain.books.Book;
import com.moaa.domain.books.properties.Author;
import com.moaa.domain.books.properties.Isbn;
import com.moaa.domain.lending.LendContract;
import com.moaa.domain.member.Member;
import com.moaa.domain.member.email.Email;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LendDatabaseTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    LendDatabase lendDatabase;

    @Before
    public void newLendDatabase(){
        lendDatabase = new LendDatabase();
    }


    @Test
    public void UnitTest_HappyPath_addLendContract_GivenABookAndAMember_IsSavedInList() {
        //GIVEN
        Book book = Book.BookBuilder.book()
                .withAuthor(
                        Author.AuthorBuilder.author()
                                .withFirstName("John")
                                .withLastName("Doe")
                                .build())
                .withIsbn(Isbn.convertStringToIsbn("123.456.789"))
                .withTitle("The chronicles of John")
                .build();

        Member member = Member.MemberBuilder.buildMember()
                .withFirstName("M")
                .withLastName("R")
                .withStreetName("T")
                .withStreetNumber("100a")
                .withPostalCode("DK2056")
                .withCityName("Ghent")
                .withEmail(Email.of("x.y@cm.be"))
                .withInss("123.45.56-123.12")
                .build();

        LendContract lendContract = LendContract.LendContractBuilder.lendContract()
                .withMember(member)
                .withBook(book)
                .build();

        //WHEN

        lendDatabase.addLendContract(lendContract);

        //THEN
        Assertions.assertThat(lendDatabase.getLendContractList().get(0)).isEqualTo(lendContract);

    }

    @Test
    public void UnitTest_addLendContract_GivenABookWhichIsAlreadyRented_AndANewMember_ReturnException() {
        //GIVEN
        Book book = Book.BookBuilder.book()
                .withAuthor(
                        Author.AuthorBuilder.author()
                                .withFirstName("John")
                                .withLastName("Doe")
                                .build())
                .withIsbn(Isbn.convertStringToIsbn("123.456.789"))
                .withTitle("The chronicles of John")
                .build();

        Member member = Member.MemberBuilder.buildMember()
                .withFirstName("M")
                .withLastName("R")
                .withStreetName("T")
                .withStreetNumber("100a")
                .withPostalCode("DK2056")
                .withCityName("Ghent")
                .withEmail(Email.of("x.y@cm.be"))
                .withInss("123.45.56-123.12")
                .build();
        Member member2 = Member.MemberBuilder.buildMember()
                .withFirstName("D")
                .withLastName("FG")
                .withStreetName("RTrgdrgd")
                .withStreetNumber("100a")
                .withPostalCode("DK2056")
                .withCityName("Ghent")
                .withEmail(Email.of("yyyyyyyyyyy@cm.be"))
                .withInss("123.45.56-123.12")
                .build();

        LendContract lendContract = LendContract.LendContractBuilder.lendContract()
                .withMember(member)
                .withBook(book)
                .build();

        LendContract lendContract2 = LendContract.LendContractBuilder.lendContract()
                .withMember(member2)
                .withBook(book)
                .build();

        LendDatabase lendDatabase = new LendDatabase();

        lendDatabase.addLendContract(lendContract);
        thrown.expect(IllegalArgumentException.class);
//        thrown.("Book The chronicles of John already lent");
        lendDatabase.addLendContract(lendContract2);

    }


    @Test
    public void UnitTest_addLendContract_Given2TimesTheSameLendContract_ReturnError() {
        //GIVEN
        Book book = Book.BookBuilder.book()
                .withAuthor(
                        Author.AuthorBuilder.author()
                                .withFirstName("John")
                                .withLastName("Doe")
                                .build())
                .withIsbn(Isbn.convertStringToIsbn("123.456.789"))
                .withTitle("The chronicles of John")
                .build();

        Member member = Member.MemberBuilder.buildMember()
                .withFirstName("M")
                .withLastName("R")
                .withStreetName("T")
                .withStreetNumber("100a")
                .withPostalCode("DK2056")
                .withCityName("Ghent")
                .withEmail(Email.of("x.y@cm.be"))
                .withInss("123.45.56-123.12")
                .build();

        LendContract lendContract = LendContract.LendContractBuilder.lendContract()
                .withMember(member)
                .withBook(book)
                .build();

        LendDatabase lendDatabase = new LendDatabase();

        lendDatabase.addLendContract(lendContract);

        thrown.expect(IllegalArgumentException.class);
//        thrown.expectMessage("LendContract with Id 1 already exists in database");
        lendDatabase.addLendContract(lendContract);

    }

    @Test
    public void unitTest_HappyPath_removeLendContract() {
        Book book = Book.BookBuilder.book()
                .withAuthor(
                        Author.AuthorBuilder.author()
                                .withFirstName("John")
                                .withLastName("Doe")
                                .build())
                .withIsbn(Isbn.convertStringToIsbn("123.456.789"))
                .withTitle("The chronicles of John")
                .build();

        Member member = Member.MemberBuilder.buildMember()
                .withFirstName("M")
                .withLastName("R")
                .withStreetName("T")
                .withStreetNumber("100a")
                .withPostalCode("DK2056")
                .withCityName("Ghent")
                .withEmail(Email.of("x.y@cm.be"))
                .withInss("123.45.56-123.12")
                .build();

        LendContract lendContract = LendContract.LendContractBuilder.lendContract()
                .withMember(member)
                .withBook(book)
                .build();

        LendDatabase lendDatabase = new LendDatabase();

        lendDatabase.addLendContract(lendContract);
        //WHEN
        lendDatabase.removeLendContract(lendContract);
        //TRY
        Assertions.assertThat(lendDatabase.getLendContractList()).isEmpty();
    }

    @Test
    public void unitTest_removeLendContractWhichIsNotInTheDatabase_ThrowsException() {
        Book book = Book.BookBuilder.book()
                .withAuthor(
                        Author.AuthorBuilder.author()
                                .withFirstName("John")
                                .withLastName("Doe")
                                .build())
                .withIsbn(Isbn.convertStringToIsbn("123.456.789"))
                .withTitle("The chronicles of John")
                .build();
        Book book2 = Book.BookBuilder.book()
                .withAuthor(
                        Author.AuthorBuilder.author()
                                .withFirstName("Johnny")
                                .withLastName("Doepy")
                                .build())
                .withIsbn(Isbn.convertStringToIsbn("999.456.789"))
                .withTitle("The chronicles of Johnny p")
                .build();

        Member member = Member.MemberBuilder.buildMember()
                .withFirstName("M")
                .withLastName("R")
                .withStreetName("T")
                .withStreetNumber("100a")
                .withPostalCode("DK2056")
                .withCityName("Ghent")
                .withEmail(Email.of("x.y@cm.be"))
                .withInss("123.45.56-123.12")
                .build();

        LendContract lendContract = LendContract.LendContractBuilder.lendContract()
                .withMember(member)
                .withBook(book)
                .build();

        LendContract lendContract2 = LendContract.LendContractBuilder.lendContract()
                .withMember(member)
                .withBook(book2)
                .build();

        LendDatabase lendDatabase = new LendDatabase();

        lendDatabase.addLendContract(lendContract);
        //TRY
        thrown.expect(IllegalArgumentException.class);
//        thrown.expectMessage("LendContract with id 2 not found");
        lendDatabase.removeLendContract(lendContract2);

    }
}
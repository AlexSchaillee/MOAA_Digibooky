package com.moaa.api.lending;

import com.moaa.api.books.BookMapper;
import com.moaa.api.member.MemberMapper;
import com.moaa.domain.books.Book;
import com.moaa.domain.books.BookRepository;
import com.moaa.domain.books.properties.Author;
import com.moaa.domain.books.properties.Isbn;
import com.moaa.domain.lending.LendRepository;
import com.moaa.domain.member.Member;
import com.moaa.domain.member.MemberRepository;
import com.moaa.domain.member.email.Email;
import com.moaa.service.books.BookService;
import com.moaa.service.lending.LendService;
import com.moaa.service.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import java.time.LocalDate;

import static java.lang.String.format;
import static org.springframework.boot.SpringApplication.run;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = IntegrationLendContractControllerTest.IntegrationLendContractControllerTestRunner.class
        , webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationLendContractControllerTest {

    @LocalServerPort
    private int port;

    @Inject
    private LendService lendService;
    @Inject
    private LendContractMapper lendContractMapper;
    @Inject
    private MemberService memberService;
    @Inject
    private BookService bookService;
    @Inject
    private BookMapper bookMapper;
    @Inject
    private MemberMapper memberMapper;
    @Inject
    private LendRepository lendRepository;
    @Inject
    private MemberRepository memberRepository;
    @Inject
    private BookRepository bookRepository;

    @Ignore
    @Test
    public void newlendContractDto_givenAmemberIdAndbookIsbn_ReturnsALendContractDto() {
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

        bookService.createBook(book);
        memberService.registerMember(member);

        //GIVEN
        /*new contract through the webinterface*/
        LendContractDto receivedLendContractDto = new TestRestTemplate()
                .postForObject(format("http://localhost:%s/%s%s", port, "renting", "?memberId=" + member.getId().toString() + "&bookIsbn=" + book.getIsbn().toString())
                        , null
                        , LendContractDto.class);

        LendContractDto expectedLendContractDto = lendContractMapper.toDto(lendService.getAllLendContracts().get(0));

        Assertions.assertThat(receivedLendContractDto).isEqualToComparingFieldByField(expectedLendContractDto);


    }

    @Test
    public void deleteLendContract() {
    }

    @Test
    public void getBooksLentByMember() {
    }

    @Test
    public void getAllOverdueBooks() {
    }

    @SpringBootApplication(scanBasePackageClasses = {LendRepository.class, LendService.class, LendContractMapper.class,
            BookService.class, BookMapper.class, MemberMapper.class, MemberService.class, BookRepository.class, MemberRepository.class})
    public static class IntegrationLendContractControllerTestRunner {
        public static void main(String[] args) {
            run(IntegrationLendContractControllerTestRunner.class, args);
        }
    }
}
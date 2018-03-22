package com.moaa.service.member;

import com.moaa.domain.member.Member;
import com.moaa.domain.member.MemberRepository;
import com.moaa.domain.member.email.Email;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class MemberServiceTest {

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @Test
    public void unitTest_getMemberById_GivenAMemberId_ReturnAMemberWithThisId() {

        Member member = Member.MemberBuilder.buildMember()
                .withFirstName("Alex")
                .withLastName("Schaillee")
                .withStreetName("Streeunknonw")
                .withStreetNumber("100a")
                .withPostalCode("DK2056")
                .withCityName("Ghent")
                .withEmail(Email.of("alex.schaillee@cm.be"))
                .withInss("**Masked**")
                .build();

        Member member2 = Member.MemberBuilder.buildMember()
                .withFirstName("M")
                .withLastName("R")
                .withStreetName("T")
                .withStreetNumber("100a")
                .withPostalCode("DK2056")
                .withCityName("Ghent")
                .withEmail(Email.of("x.y@cm.be"))
                .withInss("**Masked**")
                .build();

        //GIVEN
        Mockito.when(memberRepository.getAllMembersWithoutInss()).thenReturn(Arrays.asList(member, member2));

        //WHEN
        String memberId = member.getId().toString();
        //TRY
        Assertions.assertThat(memberService.getMemberById(memberId)).isEqualTo(member);

    }

    @Test
    public void unitTest_getMemberById_givenAnUnknownId_thenThrowAnException() {
        Member member = Member.MemberBuilder.buildMember()
                .withFirstName("Alex")
                .withLastName("Schaillee")
                .withStreetName("Streeunknonw")
                .withStreetNumber("100a")
                .withPostalCode("DK2056")
                .withCityName("Ghent")
                .withEmail(Email.of("alex.schaillee@cm.be"))
                .withInss("**Masked**")
                .build();

        Member member2 = Member.MemberBuilder.buildMember()
                .withFirstName("M")
                .withLastName("R")
                .withStreetName("T")
                .withStreetNumber("100a")
                .withPostalCode("DK2056")
                .withCityName("Ghent")
                .withEmail(Email.of("x.y@cm.be"))
                .withInss("**Masked**")
                .build();

        //GIVEN
        Mockito.when(memberRepository.getAllMembersWithoutInss()).thenReturn(Arrays.asList(member, member2));

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("member with 1 not found");

        memberService.getMemberById("1");
    }
}
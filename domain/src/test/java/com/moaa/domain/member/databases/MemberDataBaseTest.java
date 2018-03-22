package com.moaa.domain.member.databases;

import com.moaa.domain.member.Member;
import com.moaa.domain.member.MemberRepository;
import com.moaa.domain.member.email.Email;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class MemberDataBaseTest {

    @Mock
    private MemberDataBase memberDataBase;

    @InjectMocks
    private MemberRepository memberRepository;

    @Test
    public void unitTest_addMember_givenAMember_AddToMemberList() {
        //GIVEN
        Member member = Member.MemberBuilder.buildMember()
                .withFirstName("Alex")
                .withLastName("Schaillee")
                .withStreetName("Streeunknonw")
                .withStreetNumber("100a")
                .withPostalCode("DK2056")
                .withCityName("Ghent")
                .withEmail(Email.of("alex.schaillee@cm.be"))
                .withInss("85.10.5-123.56")
                .build();
        //WHEN

        Mockito.when(memberDataBase.getMemberList())
                .thenReturn(Arrays.asList(member));

        memberRepository.createMember(member);

        //THEN
        Assertions.assertThat((memberDataBase.getMemberList()).contains(member));
    }
}
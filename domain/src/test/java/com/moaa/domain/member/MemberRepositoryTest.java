package com.moaa.domain.member;

import com.moaa.domain.member.databases.MemberDataBase;
import com.moaa.domain.member.email.Email;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class MemberRepositoryTest {

    @Mock
    private MemberDataBase memberDataBase;

    @InjectMocks
    private MemberRepository memberRepository;

    @Test
    public void integrationTest_getAllMembersWithoutInss_GivenAMemberList_ReturnAMemberListWithInssMasked() {
        //Given
        Member testMember = Member.MemberBuilder.buildMember()
                .withFirstName("Pierke")
                .withLastName("Pierlala")
                .withStreetName("Korenmarkt")
                .withStreetNumber("4a")
                .withCityName("Ghent")
                .withPostalCode("9000")
                .withEmail(Email.of("test@test.com"))
                .withInss("83.10.14.049-83")
                .build();

        String originalUuidAsString = testMember.getId().toString();

        Mockito.when(memberDataBase.getMemberList())
                .thenReturn(Arrays.asList(testMember));

        //When

        List<Member> maskedList = memberRepository.getAllMembersWithoutInss();

        //Then
        Assertions.assertThat(maskedList.get(0).getInss()).isEqualTo("**Masked**");
        Assertions.assertThat(maskedList.get(0).getId().toString()).isEqualTo(originalUuidAsString);
    }
}
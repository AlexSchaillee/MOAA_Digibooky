package com.moaa.api.member;


import com.moaa.domain.member.Member;
import com.moaa.domain.member.email.Email;
import org.junit.Before;
import org.junit.Test;


import static com.moaa.domain.member.Member.MemberBuilder.buildMember;
import static org.assertj.core.api.Assertions.assertThat;

public class MemberMapperTest {

    private MemberMapper memberMapper;

    @Before
    public void instantiateMapper(){
        memberMapper = new MemberMapper();
    }

    @Test
    public void toDto() {
        Member member = buildMember()
                .withInss("111")
                .withFirstName("Alex")
                .withLastName("Schaillée")
                .withEmail(Email.of("alex.Schaillee@cm.be"))
                .withStreetName("Vossel")
                .withStreetNumber("2A")
                .withPostalCode("B9450")
                .withCityName("Brussel")
                .build();

        MemberDTO memberDTO = memberMapper.toDto(member);

        assertThat(memberDTO.getInss())
                .isEqualTo(member.getInss());

        assertThat(memberDTO.getFirstName())
                .isEqualTo(member.getFirstName());

        assertThat(memberDTO.getLastName())
                .isEqualTo(member.getLastName());

        assertThat(memberDTO.getEmail())
                .isEqualTo(member.getEmail().toString());

        assertThat(memberDTO.getStreetName())
                .isEqualTo(member.getStreetName());

        assertThat(memberDTO.getStreetNumber())
                .isEqualTo(member.getStreetNumber());

        assertThat(memberDTO.getPostalCode())
                .isEqualTo(member.getPostalCode());

        assertThat(memberDTO.getCityName())
                .isEqualTo(member.getCityName());
    }

    @Test
    public void toDomain() {
        MemberDTO memberDTO = MemberDTO.memberDTO()
                .withInss("111")
                .withFirstName("Alex")
                .withLastName("Schaillee")
                .withEmail("alex.schaillee@cm.be")
                .withStreetName("Vossel")
                .withStreetNumber("2A")
                .withPostalCode("B9450")
                .withCityName("Brussel");

        Member member = memberMapper.toDomain(memberDTO);

        assertThat(member.getInss())
                .isEqualTo(memberDTO.getInss());

        assertThat(member.getFirstName())
                .isEqualTo(memberDTO.getFirstName());

        assertThat(member.getLastName())
                .isEqualTo(memberDTO.getLastName());

        assertThat(member.getEmail().toString())
                .isEqualTo(memberDTO.getEmail());

        assertThat(member.getStreetName())
                .isEqualTo(memberDTO.getStreetName());

        assertThat(member.getStreetNumber())
                .isEqualTo(memberDTO.getStreetNumber());

        assertThat(member.getPostalCode())
                .isEqualTo(memberDTO.getPostalCode());

        assertThat(member.getCityName())
                .isEqualTo(memberDTO.getCityName());
    }
}
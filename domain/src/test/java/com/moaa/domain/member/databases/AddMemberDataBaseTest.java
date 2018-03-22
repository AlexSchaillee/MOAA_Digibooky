package com.moaa.domain.member.databases;

import com.moaa.domain.member.Member;
import com.moaa.domain.member.email.Email;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AddMemberDataBaseTest {


    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public void unitTest_addMember_givenAMemberWithINSSAlreadyInTheDatabase_thenThrowAnException() {
        //GIVEN
        MemberDataBase dataBase = new MemberDataBase();

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

        Member member2 = Member.MemberBuilder.buildMember()
                .withFirstName("John")
                .withLastName("Doe")
                .withStreetName("WhateverStreet")
                .withStreetNumber("1")
                .withPostalCode("B1234")
                .withCityName("Brussels")
                .withEmail(Email.of("john.doe@whatever.com"))
                .withInss("85.10.5-123.56")
                .build();

        //WHEN

        dataBase.addMember(member);

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("User with Inss "+member.getInss()+" already in database");
        dataBase.addMember(member2);

    }

    @Test
    public void unitTest_addMember_givenAMemberWithEmailAlreadyInTheDatabase_thenThrowAnException() {
        //GIVEN
        MemberDataBase dataBase = new MemberDataBase();

        Member member = Member.MemberBuilder.buildMember()
                .withFirstName("Alex")
                .withLastName("Schaillee")
                .withStreetName("Streeunknonw")
                .withStreetNumber("100a")
                .withPostalCode("DK2056")
                .withCityName("Ghent")
                .withEmail(Email.of("alex.schaillee@cm.be"))
                .withInss("85.10.5-123.55")
                .build();

        Member member2 = Member.MemberBuilder.buildMember()
                .withFirstName("John")
                .withLastName("Doe")
                .withStreetName("WhateverStreet")
                .withStreetNumber("1")
                .withPostalCode("B1234")
                .withCityName("Brussels")
                .withEmail(Email.of("alex.schaillee@cm.be"))
                .withInss("85.10.5-123.56")
                .build();

        //WHEN

        dataBase.addMember(member);

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("User with email "+member.getEmail()+" already found in database");
        dataBase.addMember(member2);

    }
}

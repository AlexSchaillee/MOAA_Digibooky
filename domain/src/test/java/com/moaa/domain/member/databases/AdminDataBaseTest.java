package com.moaa.domain.member.databases;

import com.moaa.domain.member.Admin;
import com.moaa.domain.member.email.Email;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.inject.Inject;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AdminDataBaseTest {

    /*@Mock
    private Admin admin;*/

    /*@InjectMocks
    private AdminDataBase adminDataBase;*/

    @Test
    public void getAdmin_GivenDatabaseWithADefaultAdmin_ThenReturnAdminOutTheList() {
        //GIVEN
        AdminDataBase adminDataBase = new AdminDataBase();
        Admin admin = Admin.AdminBuilder.builder().setFirstName("DefaultFirstName")
                .setLastName("DefaultLastName")
                .setEmail(Email.of("default@default.com"))
                .createAdmin();

        //WHEN
        Admin actualResultAdmin = adminDataBase.getAdmin();
        admin.setId(actualResultAdmin.getId());
        //THEN
        Assertions.assertThat(actualResultAdmin).isEqualTo(admin);
    }
}
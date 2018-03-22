package com.moaa.domain.member.databases;

import com.moaa.domain.member.Admin;
import com.moaa.domain.member.email.Email;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collections;
import java.util.List;

@Named
public class AdminDataBase {

    /*private List<Admin> adminList;*/
    private Admin admin;

    public AdminDataBase() {
        this.admin = Admin.AdminBuilder.builder().setFirstName("DefaultFirstName")
                .setLastName("DefaultLastName")
                .setEmail(Email.of("default@default.com"))
                .createAdmin();
/*
        this.adminList = new ArrayList<>();

                                    */
    }

    public Admin getAdmin() {
        return admin;
    }
}

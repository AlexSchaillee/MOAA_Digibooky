package com.moaa.domain.member;

import com.moaa.domain.member.email.Email;

import java.util.Objects;
import java.util.UUID;

public class Admin {

    private UUID id;
    private String firstName;
    private String lastName;
    private Email email;

    Admin(String firstName, String lastName, Email email) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Email getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admin)) return false;
        Admin admin = (Admin) o;
        return Objects.equals(id, admin.id) &&
                Objects.equals(firstName, admin.firstName) &&
                Objects.equals(lastName, admin.lastName) &&
                Objects.equals(email, admin.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, email);
    }

    public static class AdminBuilder {
        private String firstName;
        private String lastName;
        private Email email;

        public static AdminBuilder builder(){
            return new AdminBuilder();
        }

        public AdminBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public AdminBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public AdminBuilder setEmail(Email email) {
            this.email = email;
            return this;
        }

        public Admin createAdmin() {
            return new Admin(firstName, lastName, email);
        }
    }
}

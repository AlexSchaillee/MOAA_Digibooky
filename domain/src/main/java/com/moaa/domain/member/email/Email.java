package com.moaa.domain.member.email;

import java.util.Objects;

public class Email {

    private String emailAddress;


    private Email(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public static Email of(String emailAddress) throws IllegalArgumentException {
        if (!EmailValidation.validate(emailAddress)) {
            throw new IllegalArgumentException("Not a valid emailaddress");
        } else {
            return new Email(emailAddress);
        }
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email)) return false;
        Email email = (Email) o;
        return Objects.equals(emailAddress, email.emailAddress);
    }

    @Override
    public int hashCode() {

        return Objects.hash(emailAddress);
    }
}

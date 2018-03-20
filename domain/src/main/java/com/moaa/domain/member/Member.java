package com.moaa.domain.member;

import com.moaa.domain.member.email.Email;

import java.util.UUID;

public class Member {

    private UUID id;
    private String inss;
    private String firstName;
    private String lastName;
    private Email email;
    private String streetName;
    private String streetNumber;
    private String postalCode;
    private String cityName;

    private Member(String inss, String firstName, String lastName, Email email
            , String streetName, String streetNumber, String postalCode, String cityName) {
        this.id = UUID.randomUUID();
        this.inss = inss;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.cityName = cityName;
    }

    public UUID getId() {
        return id;
    }

    public String getInss() {
        return inss;
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

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCityName() {
        return cityName;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email=" + email +
                ", streetName='" + streetName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }

    public static class MemberBuilder {
        private String inss;
        private String firstName;
        private String lastName;
        private Email email;
        private String streetName;
        private String streetNumber;
        private String postalCode;
        private String cityName;

        public static MemberBuilder buildMember() {
            return new MemberBuilder();
        }

        public MemberBuilder withInss(String inss) {
            this.inss = inss;
            return this;
        }

        public MemberBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public MemberBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public MemberBuilder withEmail(Email email) {
            this.email = email;
            return this;
        }

        public MemberBuilder withStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public MemberBuilder withStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public MemberBuilder withPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public MemberBuilder withCityName(String cityName) {
            this.cityName = cityName;
            return this;
        }

        public Member build() {
            return new Member(inss, firstName, lastName, email
                    , streetName, streetNumber, postalCode, cityName);
        }
    }
}

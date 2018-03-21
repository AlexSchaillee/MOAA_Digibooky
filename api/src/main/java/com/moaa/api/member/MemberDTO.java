package com.moaa.api.member;

public class MemberDTO {
    private String id;
    private String inss;
    private String firstName;
    private String lastName;
    private String email;
    private String streetName;
    private String streetNumber;
    private String postalCode;
    private String cityName;

    private MemberDTO() {
    }

    public static MemberDTO memberDTO() {
        return new MemberDTO();
    }

    public MemberDTO withId(String id){
        this.id = id;
        return this;
    }

    public MemberDTO withInss(String inss) {
        this.inss = inss;
        return this;
    }

    public MemberDTO withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public MemberDTO withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public MemberDTO withEmail(String email) {
        this.email = email;
        return this;
    }

    public MemberDTO withStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public MemberDTO withStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
        return this;
    }

    public MemberDTO withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public MemberDTO withCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public String getId() {
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

    public String getEmail() {
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
}

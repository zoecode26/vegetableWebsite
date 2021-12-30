package com.vegetables.website.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "application_user")
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Email
    @NotEmpty
    @Column(unique=true)
    private String email;
    @Column
    @NotEmpty
    private String password;
    @Column
    @NotEmpty
    private String firstName;
    @Column
    @NotEmpty
    private String surname;
    @Column
    @NotEmpty
    private Long phoneNumber;
    @Column
    @NotEmpty
    private String addressLineOne;
    @Column
    private String addressLineTwo;
    @Column
    private String city;
    @Column
    private String county;
    @Column
    @NotEmpty
    private String postcode;
    @Column(columnDefinition = "boolean default true")
    private Boolean billToDeliveryAddress;
    @Column
    private String billingAddressLineOne;
    @Column
    private String billingAddressLineTwo;
    @Column
    private String billingCity;
    @Column
    private String billingCounty;
    @Column
    private String billingPostcode;

    public ApplicationUser() {}

    public ApplicationUser(String email, String password, String firstName, String surname, Long phoneNumber, String addressLineOne, String addressLineTwo, String city, String county, String postCode, String billingAddressLineOne, String billingAddressLineTwo, String billingCity, String billingCounty, String billingPostCode, boolean billToDeliveryAddress) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.addressLineOne = addressLineOne;
        this.addressLineTwo = addressLineTwo;
        this.city = city;
        this.county = county;
        this.postcode = postcode;
        this.billToDeliveryAddress = billToDeliveryAddress;
        this.billingAddressLineOne = billingAddressLineOne;
        this.billingAddressLineTwo = billingAddressLineTwo;
        this.billingCity = billingCity;
        this.billingCounty = billingCounty;
        this.billingPostcode = billingPostcode;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Boolean getBillToDeliveryAddress() {
        return billToDeliveryAddress;
    }

    public void setBillToDeliveryAddress(Boolean billToDeliveryAddress) {
        this.billToDeliveryAddress = billToDeliveryAddress;
    }

    public String getBillingAddressLineOne() {
        return billingAddressLineOne;
    }

    public void setBillingAddressLineOne(String billingAddressLineOne) {
        this.billingAddressLineOne = billingAddressLineOne;
    }

    public String getBillingAddressLineTwo() {
        return billingAddressLineTwo;
    }

    public void setBillingAddressLineTwo(String billingAddressLineTwo) {
        this.billingAddressLineTwo = billingAddressLineTwo;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingCounty() {
        return billingCounty;
    }

    public void setBillingCounty(String billingCounty) {
        this.billingCounty = billingCounty;
    }

    public String getBillingPostcode() {
        return billingPostcode;
    }

    public void setBillingPostcode(String billingPostcode) {
        this.billingPostcode = billingPostcode;
    }

    @Override
    public String toString() {
        return "ApplicationUser{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", addressLineOne='" + addressLineOne + '\'' +
                ", addressLineTwo='" + addressLineTwo + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", postcode='" + postcode + '\'' +
                ", billToDeliveryAddress=" + billToDeliveryAddress +
                ", billingAddressLineOne='" + billingAddressLineOne + '\'' +
                ", billingAddressLineTwo='" + billingAddressLineTwo + '\'' +
                ", billingCity='" + billingCity + '\'' +
                ", billingCounty='" + billingCounty + '\'' +
                ", billingPostcode='" + billingPostcode + '\'' +
                '}';
    }
}

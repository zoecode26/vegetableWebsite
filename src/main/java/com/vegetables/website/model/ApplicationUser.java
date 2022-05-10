package com.vegetables.website.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
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
    private String county;

    @Column
    private String city;

    @Column
    @NotEmpty
    private String postcode;

    public ApplicationUser() {}

    public ApplicationUser(long id, String email, String password, String firstName, String surname, Long phoneNumber,
                           String addressLineOne, String addressLineTwo, String county, String city, String postcode) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.addressLineOne = addressLineOne;
        this.addressLineTwo = addressLineTwo;
        this.county = county;
        this.city = city;
        this.postcode = postcode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicationUser that = (ApplicationUser) o;
        return id == that.id && Objects.equals(email, that.email) && Objects.equals(password, that.password)
                && Objects.equals(firstName, that.firstName) && Objects.equals(surname, that.surname)
                && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(addressLineOne, that.addressLineOne)
                && Objects.equals(addressLineTwo, that.addressLineTwo) && Objects.equals(county, that.county)
                && Objects.equals(city, that.city) && Objects.equals(postcode, that.postcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, firstName, surname, phoneNumber, addressLineOne, addressLineTwo,
                county, city, postcode);
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
                ", county='" + county + '\'' +
                ", city='" + city + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }
}

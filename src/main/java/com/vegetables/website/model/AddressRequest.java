package com.vegetables.website.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class AddressRequest {
    private String addressLineOne;
    private String addressLineTwo;
    private String city;
    private String county;
    private String postcode;

    public AddressRequest() {}

    public AddressRequest(String addressLineOne, String addressLineTwo, String city, String county, String postcode) {
        this.addressLineOne = addressLineOne;
        this.addressLineTwo = addressLineTwo;
        this.city = city;
        this.county = county;
        this.postcode = postcode;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressRequest that = (AddressRequest) o;
        return Objects.equals(addressLineOne, that.addressLineOne) && Objects.equals(addressLineTwo, that.addressLineTwo) && Objects.equals(city, that.city) && Objects.equals(county, that.county) && Objects.equals(postcode, that.postcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressLineOne, addressLineTwo, city, county, postcode);
    }

    @Override
    public String toString() {
        return "AddressRequest{" +
                "addressLineOne='" + addressLineOne + '\'' +
                ", addressLineTwo='" + addressLineTwo + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }
}

package com.vegetables.website.model;

import java.util.Objects;

public class UserIdRequest {
    private String email;

    public UserIdRequest() { }

    public UserIdRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserIdRequest that = (UserIdRequest) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "UserIdRequest{" +
                "email='" + email + '\'' +
                '}';
    }
}

package com.vegetables.website.model;

public class ChargeRequest {
    private String email;
    private String stripeToken;
    private int amount;
    private String currency;
    private String description;

    public ChargeRequest() { }

    public ChargeRequest(String email, String stripeToken, int amount, String currency, String description) {
        this.email = email;
        this.stripeToken = stripeToken;
        this.amount = amount;
        this.currency = currency;
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStripeToken() {
        return stripeToken;
    }

    public void setStripeToken(String stripeToken) {
        this.stripeToken = stripeToken;
    }

    public int getAmount() { return amount; }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package com.sg.kata.BankAccountData.model;

public class JwtToken {

    private final String token;


    public JwtToken(String jwttoken) {
        this.token = jwttoken;
    }


    public String getToken() {
        return token;
    }
}

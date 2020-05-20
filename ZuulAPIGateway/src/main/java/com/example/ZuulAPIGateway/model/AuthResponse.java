package com.example.ZuulAPIGateway.model;

public class AuthResponse {
    private String JWT;

    public AuthResponse() {}

    public AuthResponse(String JWT) {
        this.JWT = JWT;
    }

    public String getJWT() {
        return JWT;
    }

    public void setJWT(String JWT) {
        this.JWT = JWT;
    }

    @Override
    public String toString() {
        return "AuthResponse{" +
                "JWT='" + JWT + '\'' +
                '}';
    }
}
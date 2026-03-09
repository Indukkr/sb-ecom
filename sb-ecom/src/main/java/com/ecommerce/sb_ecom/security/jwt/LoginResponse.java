package com.ecommerce.sb_ecom.security.jwt;

import java.util.List;

public class LoginResponse {

    private String username;

    private String jwtToken;

    private List<String> role;

    public LoginResponse(String username, String jwtToken, List<String> role) {
        this.username = username;
        this.jwtToken = jwtToken;
        this.role = role;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }
}

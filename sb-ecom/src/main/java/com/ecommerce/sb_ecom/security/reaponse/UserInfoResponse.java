package com.ecommerce.sb_ecom.security.reaponse;

import java.util.List;

public class UserInfoResponse {

    private Long id;
    private String username;

    private String jwtToken;

    private List<String> role;

    public UserInfoResponse(Long id ,String username, String jwtToken, List<String> role) {
        this.id = id;
        this.username = username;
        this.jwtToken = jwtToken;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

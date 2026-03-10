package com.ecommerce.sb_ecom.security.reaponse;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserInfoResponse {

    private Long id;
    private String username;

    private String jwtToken;

    private List<String> roles;

    public UserInfoResponse(Long id ,String username, List<String> roles) {
        this.id = id;
        this.username = username;
        this.jwtToken = jwtToken;
        this.roles = roles;
    }



}

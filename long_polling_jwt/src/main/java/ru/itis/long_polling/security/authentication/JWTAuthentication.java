package ru.itis.long_polling.security.authentication;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class JWTAuthentication implements Authentication {

    private Boolean isAuthenticated;
    private String token;
    private UserDetails userDetails;


    public JWTAuthentication() {
        isAuthenticated = false;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userDetails.getAuthorities();
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return userDetails;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        isAuthenticated = b;
    }

    @Override
    public String getName() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}

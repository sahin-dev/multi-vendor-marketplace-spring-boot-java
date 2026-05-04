package com.bestkid.bestkid_api.security;

import java.util.Collection;
import java.util.Collections;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bestkid.bestkid_api.entity.User;

public class CustomUserDetails implements UserDetails{

    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        return Collections.singleton(new SimpleGrantedAuthority(this.user.getRole()));
    }

    @Override
    public @Nullable String getPassword() {
        
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        

        return this.user.getEmail();
    }

}

package com.bestkid.bestkid_api.security.jwt;
import java.util.Collection;

import org.jspecify.annotations.Nullable;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private final String token;
    private final Object principal;

    public JwtAuthenticationToken(String token) {
        
        super((Collection<? extends GrantedAuthority>) null);
        this.token = token;
        this.principal = null;
        this.setAuthenticated(false);
    }

     public JwtAuthenticationToken(Object principal,
                                  String token,
                                  Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.token = token;
        this.principal = principal;
        setAuthenticated(true);
    }

    @Override
    public @Nullable Object getCredentials() {
        
        return this.token;
    }

    @Override
    public @Nullable Object getPrincipal() {
        return this.principal;
    }
    
}

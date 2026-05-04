package com.bestkid.bestkid_api.security;

import org.jspecify.annotations.Nullable;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthProvider implements AuthenticationProvider{

    private final CustomUserDetailsService userDetailsService;

    public CustomAuthProvider(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public @Nullable Authentication authenticate(Authentication authentication) throws AuthenticationException {
      
        String userName = authentication.getName();
    
        String password = (String) authentication.getCredentials();

      
        UserDetails userDetails =  userDetailsService.loadUserByUsername(userName);

        if(userDetails.getPassword().equals(password)){
            return new UsernamePasswordAuthenticationToken(userName, password, userDetails.getAuthorities());
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
    
}

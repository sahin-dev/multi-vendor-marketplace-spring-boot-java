package com.bestkid.bestkid_api.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bestkid.bestkid_api.entity.User;
import com.bestkid.bestkid_api.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("Loading user by email: " + email);
        User user =this.userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User with this "+email+" does not exists!"));
            
        return new CustomUserDetails(user);
    }

}

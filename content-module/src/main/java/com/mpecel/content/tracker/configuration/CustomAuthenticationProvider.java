package com.mpecel.content.tracker.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // authenticated request - fully authenticated Authentication instance

        // not authenticated request - throw an exception (AuthenticationException)

        // the authentication is not supported by this Authentication Provider
        String username = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if(userDetails != null) {
            if(passwordEncoder.matches(password, userDetails.getPassword())) {
                return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
            }
        }
        throw new BadCredentialsException("Error!");
    }

    @Override
    public boolean supports(Class<?> authenticationType) { // type of authentication
        return UsernamePasswordAuthenticationToken.class.equals(authenticationType);
    }
}

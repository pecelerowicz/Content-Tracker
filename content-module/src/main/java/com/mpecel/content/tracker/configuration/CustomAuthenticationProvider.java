package com.mpecel.content.tracker.configuration;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = (String)authentication.getPrincipal();
        String password = (String)authentication.getCredentials();

        System.out.println("------");
        System.out.println(username);
        System.out.println(password);
        System.out.println("------");

        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return CustomAuthentication.class.equals(aClass);
    }
}

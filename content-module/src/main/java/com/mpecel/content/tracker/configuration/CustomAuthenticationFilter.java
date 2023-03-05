package com.mpecel.content.tracker.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class CustomAuthenticationFilter implements Filter {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String customAuthorization = httpServletRequest.getHeader("CustomAuthorization");

        String principal = extractPrincipal(customAuthorization);
        String credentials = extractPassword(customAuthorization);

        var customAuthentication = new CustomAuthentication(principal, credentials);

        Authentication resultAuthentication = authenticationManager.authenticate(customAuthentication);


        if(resultAuthentication.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(resultAuthentication);
            chain.doFilter(request, response);
        }
    }

    private String extractPrincipal(String customAuthorization) {
        return customAuthorization.split(";")[0];
    }

    private String extractPassword(String customAuthorization) {
        return customAuthorization.split(";")[1];
    }
}

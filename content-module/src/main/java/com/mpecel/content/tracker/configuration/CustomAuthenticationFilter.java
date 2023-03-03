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
        String authorization = httpServletRequest.getHeader("Authorization");

        var a = new CustomAuthentication(authorization, null);
        Authentication result = authenticationManager.authenticate(a);

        if(result.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(result);
            chain.doFilter(request, response);
        }
    }
}

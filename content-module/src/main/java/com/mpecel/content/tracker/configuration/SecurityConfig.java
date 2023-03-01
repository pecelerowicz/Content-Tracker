package com.mpecel.content.tracker.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
//        var uds = new InMemoryUserDetailsManager();
//        var u1 = User.withUsername("mpecel")
//                .password("mpecel_pass")
//                .authorities("read")
//                .build();
//        uds.createUser(u1);
        var uds = new InMemoryUserDetailsManager();
        UserDetails user = CustomUser.builder()
                .authorities(List.of(new SimpleGrantedAuthority("read")))
                .username("mpecel")
                .password("mpecel_pass")
                .isEnabled(true)
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .build();
        uds.createUser(user);
        return uds;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}

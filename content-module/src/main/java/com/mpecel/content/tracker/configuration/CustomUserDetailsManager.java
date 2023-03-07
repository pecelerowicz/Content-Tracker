package com.mpecel.content.tracker.configuration;

import com.mpecel.content.tracker.model.User;
import com.mpecel.content.tracker.service.UserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import javax.el.MethodNotFoundException;

@Component
@NoArgsConstructor
public class CustomUserDetailsManager implements UserDetailsManager {
    @Autowired
    private UserService userService;

    @Override
    public void createUser(UserDetails userDetails) {
        throw new MethodNotFoundException("Not implemented yet");
    }

    @Override
    public void updateUser(UserDetails userDetails) {
        throw new MethodNotFoundException("Not implemented yet");
    }

    @Override
    public void deleteUser(String s) {
        throw new MethodNotFoundException("Not implemented yet");
    }

    @Override
    public void changePassword(String s, String s1) {
        throw new MethodNotFoundException("Not implemented yet");
    }

    @Override
    public boolean userExists(String username) {
        try {
            User user = userService.getUser(username);
            return true;
        } catch (UsernameNotFoundException e) {
            return false;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return CustomUserDetails.builder().user(userService.getUser(username)).build();
    }
}

package com.mpecel.content.tracker.controller;

import com.mpecel.content.tracker.dto.user.*;
import com.mpecel.content.tracker.model.User;
import com.mpecel.content.tracker.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.el.MethodNotFoundException;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    /**
     * Method unprotected
     */
    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest registerRequest) {
        User addedUser = userService.register(registerRequest);
        return RegisterResponse.builder().message("User with id " + addedUser.getId() + " was added.").build();
    }

    /**
     * Method unprotected
     * Post just to send data
     */
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        throw new MethodNotFoundException();
    }

    /**
     * Available for the logged user
     */
    @PutMapping("/modify")
    public ModifyResponse modify(@RequestBody ModifyRequest modifyRequest) {
        throw new MethodNotFoundException();
    }

}

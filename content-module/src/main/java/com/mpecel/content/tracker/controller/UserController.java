package com.mpecel.content.tracker.controller;

import com.mpecel.content.tracker.dto.AddUserRequest;
import com.mpecel.content.tracker.dto.AddUserResponse;
import com.mpecel.content.tracker.dto.GetUserResponse;
import com.mpecel.content.tracker.dto.GetUsersResponse;
import com.mpecel.content.tracker.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;
    @GetMapping
    public GetUsersResponse getUsers() {
        return GetUsersResponse.builder()
                .getUserResponseList(
                        userService.getUsers()
                                .stream()
                                .map(GetUserResponse::new)
                                .toList())
                .build();
    }
    @PostMapping
    public AddUserResponse addUser(@RequestBody AddUserRequest addUserRequest) {
        return userService.addUser(addUserRequest);
    }
}

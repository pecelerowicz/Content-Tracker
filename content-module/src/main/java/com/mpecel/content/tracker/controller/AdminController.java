package com.mpecel.content.tracker.controller;

import com.mpecel.content.tracker.dto.admin.*;
import com.mpecel.content.tracker.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.el.MethodNotFoundException;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {
    private final AdminService adminService;
    @GetMapping
    public GetUsersResponse getUsers() {
        return GetUsersResponse.builder()
                .getUserResponseList(adminService.getUsers().stream().map(GetUserResponse::new).toList())
                .build();
    }
    @GetMapping("/{userName}")
    public GetUserResponse getUser(@PathVariable("userName") String userName) {
        throw new MethodNotFoundException();
    }
    @PutMapping
    public ModifyUserResponse modifyUser(@RequestBody ModifyUserRequest modifyUserRequest) {
        throw new MethodNotFoundException();
    }
    @DeleteMapping
    public DeleteUserResponse deleteUser(@RequestBody DeleteUserRequest deleteUserRequest) {
        throw new MethodNotFoundException();
    }
}

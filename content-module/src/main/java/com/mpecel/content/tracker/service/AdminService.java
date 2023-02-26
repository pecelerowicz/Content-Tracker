package com.mpecel.content.tracker.service;

import com.mpecel.content.tracker.model.User;
import com.mpecel.content.tracker.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminService {
    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}

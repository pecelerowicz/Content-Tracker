package com.mpecel.content.tracker.service;

import com.mpecel.content.tracker.dto.user.RegisterRequest;
import com.mpecel.content.tracker.model.User;
import com.mpecel.content.tracker.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User register(RegisterRequest registerRequest) {
        return userRepository.save(User.builder()
                .userName(registerRequest.getUserName())
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .password(registerRequest.getPassword())
                .created(LocalDateTime.now())
                .build());
    }
}

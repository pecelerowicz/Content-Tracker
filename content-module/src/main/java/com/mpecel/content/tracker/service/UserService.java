package com.mpecel.content.tracker.service;

import com.mpecel.content.tracker.dto.AddUserRequest;
import com.mpecel.content.tracker.dto.AddUserResponse;
import com.mpecel.content.tracker.model.Expression;
import com.mpecel.content.tracker.model.User;
import com.mpecel.content.tracker.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public AddUserResponse addUser(AddUserRequest addUserRequest) {
        User addedUser = userRepository.save(User.builder()
                .userName(addUserRequest.getUserName())
                .firstName(addUserRequest.getFirstName())
                .lastName(addUserRequest.getLastName())
                .email(addUserRequest.getEmail())
                .password(addUserRequest.getPassword())
                .created(LocalDateTime.now())
                .build());
        return AddUserResponse.builder().message("User with id " + addedUser.getId() + " was added.").build();
    }
}
//
//    private Long id;
//    private String userName;
//    private String firstName;
//    private String lastName;
//    private String email;
//    private String password;
//    private LocalDateTime created;
//    @OneToMany(mappedBy = "user")
//    private List<Expression> expressions;

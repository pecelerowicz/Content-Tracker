package com.mpecel.content.tracker;

import com.mpecel.content.tracker.model.User;
import com.mpecel.content.tracker.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class ContentApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ContentApplication.class, args);
    }

    private final UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        List<User> usersToSave = new LinkedList<>();
        User user1 = User.builder().userName("user1").firstName("user1").lastName("user1").email("user1").password("user1").created(LocalDateTime.now()).build();
        User user2 = User.builder().userName("user2").firstName("user2").lastName("user2").email("user2").password("user2").created(LocalDateTime.now()).build();
        User user3 = User.builder().userName("user3").firstName("user3").lastName("user3").email("user3").password("user3").created(LocalDateTime.now()).build();
        User user4 = User.builder().userName("user4").firstName("user4").lastName("user4").email("user4").password("user4").created(LocalDateTime.now()).build();
        usersToSave.add(user1);
        usersToSave.add(user2);
        usersToSave.add(user3);
        usersToSave.add(user4);
        userRepository.saveAllAndFlush(usersToSave);
    }
}

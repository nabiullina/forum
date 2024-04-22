package com.nabiullina.forum.services;

import com.nabiullina.forum.models.User;
import com.nabiullina.forum.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.*;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }
//
//    public List<User> getUsersByName(String name) {
//        if (name.isEmpty()){
//            return userRepository.findAll();
//        }
//
//        return userRepository.findUsersByName(name);
//    }

    public void saveUser(User user) {
        log.info("Saving new user: {}", user);
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
        log.info("Deleting user with id: {}", id);
    }

}

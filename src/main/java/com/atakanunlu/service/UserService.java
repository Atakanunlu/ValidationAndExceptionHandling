package com.atakanunlu.service;

import com.atakanunlu.entity.User;
import com.atakanunlu.exception.UserNotFoundException;
import com.atakanunlu.mapper.UserMapper;
import com.atakanunlu.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
@Builder
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @PostConstruct
    public void init() {
        if (userRepository.count() == 0) {
            User defaultUser = new User();
            defaultUser.setName("Atakan");
            defaultUser.setEmail("atakan@gmail.com");
            defaultUser.setMobile("5355747603");
            defaultUser.setGender("Male");
            defaultUser.setAge(23);
            defaultUser.setNationality("Turkish");
            userRepository.save(defaultUser);
        }
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getAllUsersSortedByAge(String sortByAge) {
        List<User> users;
        if ("asc".equalsIgnoreCase(sortByAge)) {
            users = userRepository.findAllByOrderByAgeAsc();
        } else if ("desc".equalsIgnoreCase(sortByAge)) {
            users = userRepository.findAllByOrderByAgeDesc();
        } else {
            users = userRepository.findAll();
        }
        return users;
    }

    public User getUser(int id) throws UserNotFoundException {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Kullanıcı id ile bulunamadı: " + id));
    }

    public User getUserByName(String name) throws UserNotFoundException {
        List<User> users = userRepository.findByName(name);
        if (!users.isEmpty()) {
            return users.get(0);
        } else {
            throw new UserNotFoundException("Kullanıcı isim ile bulunamadı: " + name);
        }
    }
}

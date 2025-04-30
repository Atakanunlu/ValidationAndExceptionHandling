package com.atakanunlu.repository;

import com.atakanunlu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserId(int id);

    List<User> findAllByOrderByAgeAsc();
    List<User> findAllByOrderByAgeDesc();
    List<User> findByName(String name);

}

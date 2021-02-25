package com.batch2.latihan.services;

import com.batch2.latihan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByEmailAndUserName(String email, String username);
}

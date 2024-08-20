package com.samsung.finaljava2.repository;

import com.samsung.finaljava2.repository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

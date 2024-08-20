package com.samsung.finaljava2.service;

import com.samsung.finaljava2.config.CustomUserDetails;
import com.samsung.finaljava2.repository.UserRepo;
import com.samsung.finaljava2.repository.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService, IUserService {
    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        else {
            return new CustomUserDetails(user);
        }
    }

    @Override
    public void createUser(User user) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

        User newUser = User
                .builder()
                .username(user.getUsername())
                .password(passwordEncoder.encode(user.getPassword()))
                .email(user.getEmail())
                .fullName(user.getFullName())
                .build();

        userRepo.save(newUser);
    }
}

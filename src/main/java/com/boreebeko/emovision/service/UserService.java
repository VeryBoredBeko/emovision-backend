package com.boreebeko.emovision.service;

import com.boreebeko.emovision.repository.UserRepository;
import com.boreebeko.emovision.security.Role;
import com.boreebeko.emovision.security.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User create(User user) {

        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("User with this username exists.");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("User with this email exists.");
        }

        return save(user);
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No user with such username"));
    }

    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    public User getCurrentUser() {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }

    @Deprecated
    public void getAdmin() {
        var user = getCurrentUser();
        user.setRole(Role.ROLE_ADMIN);
        save(user);
    }
}

package com.se190167.mvc.horseracingtournament.service;

import com.se190167.mvc.horseracingtournament.entity.User;
import com.se190167.mvc.horseracingtournament.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getUsersByRole(String role) {
        return userRepository.findByRole(role);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public boolean isEmailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    public void toggleUserStatus(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setStatus(user.getStatus().equals("active") ? "inactive" : "active");
            userRepository.save(user);
        }
    }

    public List<User> getRecentUsers(int limit) {
        return userRepository.findTop5ByOrderByIdDesc();
    }
}
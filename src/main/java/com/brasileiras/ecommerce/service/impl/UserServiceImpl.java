package com.brasileiras.ecommerce.service.impl;

import com.brasileiras.ecommerce.model.User;
import com.brasileiras.ecommerce.repository.UserRepository;
import com.brasileiras.ecommerce.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void update(Long userId, User user) {
        User existingUser = findById(userId);
        existingUser.setName(user.getName());
        existingUser.setCpf(user.getCpf());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());
        existingUser.setPassword(user.getPassword());

        userRepository.save(existingUser);
    }


    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}

package com.brasileiras.service;

import com.brasileiras.model.User;
import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User save(User user);
    void update(Long accountReceiveId, User Uuser);
    void delete(Long id);
}

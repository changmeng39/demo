package com.service;

import com.entity.User;
import java.util.List;

public interface UserService {
    List<User> findAll();

    int insert(User user);
}

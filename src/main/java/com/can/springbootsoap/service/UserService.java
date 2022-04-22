package com.can.springbootsoap.service;

import com.can.springbootsoap.model.User;

public interface UserService {


    User getUserById(Integer userId);
    User createUser(User user);
}

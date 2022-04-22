package com.can.springbootsoap.service;

import com.can.springbootsoap.model.User;
import com.can.springbootsoap.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class UserServiceImpl implements UserService{
    UserRepository userRepository;

    @Override
    public User getUserById(Integer userId) {
        return userRepository.getById(userId);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}

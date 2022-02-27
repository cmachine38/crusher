package com.construction.crusher.service;

import com.construction.crusher.model.User;
import com.construction.crusher.repo.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class UserService2 {

    private final UserRepository userRepository;

    public UserService2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

     public User loadUserByUsername(String username)  {
        User user = userRepository.findByUsername(username);

        return user;
    }

    @Transactional(rollbackFor = Exception.class)
    public User create(User user) {
        return userRepository.save(user);
    }
}
package com.company.service.impl;

import com.company.dao.UserRepository;
import com.company.entity.User;
import com.company.service.inter.UserRepositoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserRepositoryServiceImpl implements UserRepositoryServiceInter {

    @Autowired
    private UserRepository userRepository;

    private static BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();

    @Override
    public User findByUserId(Integer id) {
        return userRepository.findByUserId(id);
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public boolean save(User user) {
        user.setPassword(crypt.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    @Override
    public User Update(User user) {
        user.setPassword(crypt.encode(user.getPassword()));
        return userRepository.save(user);
    }

}
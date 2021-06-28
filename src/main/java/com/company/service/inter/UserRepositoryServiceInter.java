package com.company.service.inter;

import com.company.entity.User;

public interface UserRepositoryServiceInter {

    User findByUserId(Integer id);

    User findByUserName(String username);

    boolean save(User user);

    User Update(User user);
}
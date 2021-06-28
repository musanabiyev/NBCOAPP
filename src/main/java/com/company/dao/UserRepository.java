package com.company.dao;

import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("From User where username=:username")
    User findByUserName(String username);

    @Query("From User where id=:id")
    User findByUserId(Integer id);

}

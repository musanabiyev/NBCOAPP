package com.company.dao;

import com.company.entity.GroupUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupUserRepository extends JpaRepository<GroupUser, Integer> {

    @Query(value = "select * from group_user where user_id = :id", nativeQuery = true)
    List<GroupUser> getGroupUserByUserId(Integer id);

}


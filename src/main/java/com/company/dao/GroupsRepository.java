package com.company.dao;

import com.company.entity.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupsRepository extends JpaRepository<Groups, Integer> {

    @Query(value = "SELECT * from groups", nativeQuery = true)
    List<Groups> getAllGroups();

    Groups findByName(String name);

    Groups findById(int groupId);

}
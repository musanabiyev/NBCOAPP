package com.company.service.impl;


import com.company.dao.GroupsRepository;
import com.company.entity.Groups;
import com.company.service.inter.GroupsRepositoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GroupsRepositoryServiceImpl implements GroupsRepositoryServiceInter {

    @Autowired
    private GroupsRepository groupsRepository;

    @Override
    public List<Groups> getAllGroups() {
        return groupsRepository.getAllGroups();
    }

    @Override
    public Groups findByName(String name) {
        return groupsRepository.findByName(name);
    }

    @Override
    public Groups findById(int groupId) {
        return groupsRepository.findById(groupId);
    }

}
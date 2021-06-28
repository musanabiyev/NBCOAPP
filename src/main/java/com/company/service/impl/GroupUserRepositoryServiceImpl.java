package com.company.service.impl;

import com.company.dao.GroupUserRepository;
import com.company.entity.GroupUser;
import com.company.service.inter.GroupUserRepositoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GroupUserRepositoryServiceImpl implements GroupUserRepositoryServiceInter {

    @Autowired
    private GroupUserRepository groupUserRepository;

    @Override
    public List<GroupUser> getGroupUserByUserId(Integer id) {
        return groupUserRepository.getGroupUserByUserId(id);
    }

}

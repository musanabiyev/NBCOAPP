package com.company.service.inter;

import com.company.entity.GroupUser;

import java.util.List;

public interface GroupUserRepositoryServiceInter {

    List<GroupUser> getGroupUserByUserId(Integer id);

}
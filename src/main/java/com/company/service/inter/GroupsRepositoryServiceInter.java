package com.company.service.inter;

import com.company.entity.Groups;

import java.util.List;

public interface GroupsRepositoryServiceInter {

    List<Groups> getAllGroups();

    Groups findByName(String name);

    Groups findById(int groupId);

}

package com.company.service.impl;

import com.company.entity.GroupUser;
import com.company.entity.User;
import com.company.service.inter.GroupUserRepositoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepositoryServiceImpl userRepo;

    @Autowired
    private GroupUserRepositoryServiceInter groupUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUserName(username);

        if (user != null) {
            UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(username);

            builder.disabled(false);
            builder.password(user.getPassword());

            List<GroupUser> groupUser = groupUserRepo.getGroupUserByUserId(user.getId());
            List<String> list = new ArrayList<>();
            for (GroupUser role : groupUser) {
                list.add(role.getGroupId().getName());
            }

            builder.authorities(list.toArray(new String[0]));

            return builder.build();
        } else {
            throw new UsernameNotFoundException("User not fount.");
        }
    }
}
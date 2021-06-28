package com.company.controller;

import com.company.dto.ResponseDTO;
import com.company.dto.UserDTO;
import com.company.entity.GroupUser;
import com.company.entity.Groups;
import com.company.entity.User;
import com.company.service.inter.GroupsRepositoryServiceInter;
import com.company.service.inter.UserRepositoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepositoryServiceInter userRepositoryService;

    @Autowired
    private GroupsRepositoryServiceInter groupsRepositoryService;

    @PostMapping(value = "/updateuser")
    public ResponseEntity<ResponseDTO> updateUser(@RequestBody UserDTO userDTO) {

        ResponseDTO response = null;

        if (userRepositoryService.findByUserId(userDTO.getId()) == null) {
            return new ResponseEntity<ResponseDTO>(
                    response.of(
                            userDTO.getId(),
                            404,
                            "Not found user"), HttpStatus.NOT_FOUND);
        }
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setPassword(userDTO.getPassword());
        userRepositoryService.Update(user);

        UserDTO uDTO = new UserDTO();
        uDTO.setId(user.getId());
        uDTO.setName(user.getName());
        uDTO.setSurname(user.getSurname());

        return ResponseEntity.ok(response.of(uDTO, "successfully update"));
    }


    @PostMapping(value = "/addUser")
    public ResponseEntity<ResponseDTO> addUser(@RequestBody UserDTO userDTO) {

        if (userRepositoryService.findByUserName(userDTO.getUsername()) != null) {
            return ResponseEntity.ok(ResponseDTO.of(userDTO.getUsername(),
                    404, "This username is taken by another account."));
        }

        Groups groups = groupsRepositoryService.findByName("USER");
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setPassword(userDTO.getPassword());
        user.setPhoneNumber(userDTO.getPhoneNumber());

        GroupUser groupUser = new GroupUser();
        groupUser.setGroupId(groups);
        groupUser.setUserId(user);
        List<GroupUser> groupUserList = new ArrayList<>();
        groupUserList.add(groupUser);
        user.setGroupUserList(groupUserList);

        userRepositoryService.save(user);

        UserDTO uDto = new UserDTO();
        uDto.setId(user.getId());
        uDto.setName(user.getName());
        uDto.setSurname(user.getSurname());
        uDto.setUsername(user.getUsername());
        uDto.setPhoneNumber(user.getPhoneNumber());

        return ResponseEntity.ok(ResponseDTO.of(uDto, "successfully added"));
    }
}
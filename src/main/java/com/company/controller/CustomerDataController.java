package com.company.controller;

import com.company.dto.CustomerDataDTO;
import com.company.dto.ResponseDTO;
import com.company.entity.CustomerData;
import com.company.entity.User;
import com.company.service.inter.CustomerDataRepositoryServiceInter;
import com.company.service.inter.UserRepositoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CustomerDataController {

    @Autowired
    private CustomerDataRepositoryServiceInter customerDataRepositoryService;

    @Autowired
    private UserRepositoryServiceInter userRepositoryService;

    @GetMapping(value = "/getcustomerdata")
    public ResponseEntity<ResponseDTO> getCustomerData(){
        return null;
    }



    @PostMapping(value = "/addcustomerdata")
    public ResponseEntity<ResponseDTO> addCustomerData
            (@RequestBody CustomerDataDTO customerDataDTO) {

        User user = userRepositoryService.findByUserId(customerDataDTO.getUserId());
        CustomerData customerData = new CustomerData();

        customerData.setUserId(user);
        customerData.setName(customerDataDTO.getName());
        customerData.setSurname(customerDataDTO.getSurname());
        customerData.setAddress(customerDataDTO.getAddress());
        customerData.setPhoneNumber(customerDataDTO.getPhoneNumber());
        customerData.setDateOfBirth(customerDataDTO.getDateOfBirth());

        customerDataRepositoryService.save(customerData);


        CustomerDataDTO cDataDTO = new CustomerDataDTO();

        cDataDTO.setName(customerData.getName());
        cDataDTO.setSurname(customerData.getSurname());
        cDataDTO.setAddress(customerData.getAddress());
        cDataDTO.setPhoneNumber(customerData.getPhoneNumber());
        cDataDTO.setDateOfBirth(customerData.getDateOfBirth());
        cDataDTO.setUserId(user.getId());
        cDataDTO.setId(customerData.getId());

        return ResponseEntity.ok(ResponseDTO.of(cDataDTO, "successfully added"));
    }
}
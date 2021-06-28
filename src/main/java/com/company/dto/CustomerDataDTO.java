package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDataDTO {

    private Integer id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String address;
    private Date dateOfBirth;
    private Integer userId;

}
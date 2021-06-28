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
public class PaymentDataDTO {

    private Integer Id;
    private Double amount;
    private Date date;
    private IssuedloanDataDTO creditId;

}

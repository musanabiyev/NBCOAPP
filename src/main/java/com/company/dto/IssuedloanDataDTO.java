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
public class IssuedloanDataDTO {

    private Integer id;
    private Double paymentNo;
    private Double amountOfPayment;
    private Date paymentDate;
    private Double mainDebt;
    private Double interestCharges;
    private Double remainingDebt;
    private Integer issuedloanId;

}
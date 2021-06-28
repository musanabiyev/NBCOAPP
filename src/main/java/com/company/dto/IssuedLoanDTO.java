package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IssuedLoanDTO {

    private Integer id;
    private Date startDateOfLoan;
    private Date endDateOfLoan;
    private Double durationPerMonth;
    private Double amount;
    private Double percentage;
    private CustomerDataDTO customerDataId;
    private List<PaymentDataDTO> paymentDataList;
    private List<IssuedloanDataDTO> issuedloanDataList;
}

package com.company.controller;

import com.company.dto.PaymentDataDTO;
import com.company.dto.ResponseDTO;
import com.company.entity.PaymentData;
import com.company.service.inter.PaymentDataRepositoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class PaymentDataController {

    @Autowired
    private PaymentDataRepositoryServiceInter paymentDataRepositoryService;

    @GetMapping(value = "/getPayment")
    public ResponseEntity<ResponseDTO> getPayment(@RequestParam("id") int id) {
        PaymentData paymentData = paymentDataRepositoryService.findPaymentDataByCreditId(id);
        PaymentDataDTO paymentDataDTO = new PaymentDataDTO();

        paymentDataDTO.setDate(paymentData.getDate());
        paymentDataDTO.setAmount(paymentData.getAmount());

        return ResponseEntity.ok(ResponseDTO.of(paymentDataDTO, "successfully get payment data"));
    }
}
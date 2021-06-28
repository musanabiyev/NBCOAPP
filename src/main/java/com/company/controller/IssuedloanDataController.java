package com.company.controller;

import com.company.dto.IssuedloanDataDTO;
import com.company.dto.ResponseDTO;
import com.company.entity.*;
import com.company.service.inter.IssuedLoanDataRepositoryServiceInter;
import com.company.service.inter.IssuedLoanRepositoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class IssuedloanDataController {

    @Autowired
    private IssuedLoanDataRepositoryServiceInter issuedLoanDataRepositoryService;

    @Autowired
    private IssuedLoanRepositoryServiceInter issuedLoanRepositoryService;

    @GetMapping(value = "/getIssuedloan")
    public ResponseEntity<ResponseDTO> getIssuedloanData(@RequestParam("id") int id) {

        List<IssuedloanData> creditDataList = issuedLoanDataRepositoryService.findByIssuedloanId(id);

        ResponseDTO response = null;

        if (creditDataList.isEmpty()) {
            return new ResponseEntity<ResponseDTO>(
                    response.of(creditDataList,
                            404,
                            "Not found Issued loan data"), HttpStatus.NOT_FOUND);
        }

        List<Object> dataDTO = new ArrayList<>();

        for (IssuedloanData data : creditDataList) {

            dataDTO.add(data.getId());
            dataDTO.add(data.getAmountOfPayment());
            dataDTO.add(data.getPaymentDate());
            dataDTO.add(data.getPaymentNo());
            dataDTO.add(data.getInterestCharges());
            dataDTO.add(data.getMainDebt());
            dataDTO.add(data.getRemainingDebt());

        }

        return ResponseEntity.ok(ResponseDTO.of(dataDTO));
    }




    @PostMapping(value = "/addissueddata")
    public ResponseEntity<ResponseDTO> addIssuedLoanData(
            @RequestBody IssuedloanDataDTO issuedloanDataDTO) {
        ResponseDTO response = null;
        IssuedLoan issuedLoan = issuedLoanRepositoryService.findByIssudeId(issuedloanDataDTO.getIssuedloanId());

        if (issuedLoan == null) {
            return new ResponseEntity<ResponseDTO>(
                    response.of(issuedloanDataDTO.getIssuedloanId(),
                            404,
                            "Not found Issued loan id"), HttpStatus.NOT_FOUND);
        }


        IssuedloanData issuedloanData = new IssuedloanData();
        issuedloanData.setIssuedloanId(issuedLoan);
        issuedloanData.setPaymentDate(issuedloanDataDTO.getPaymentDate());
        issuedloanData.setMainDebt(issuedloanDataDTO.getMainDebt());
        issuedloanData.setInterestCharges(issuedloanData.getInterestCharges());
        issuedloanData.setRemainingDebt(issuedloanDataDTO.getRemainingDebt());
        issuedloanData.setAmountOfPayment(issuedloanDataDTO.getAmountOfPayment());
        issuedloanData.setPaymentNo(issuedloanDataDTO.getPaymentNo());


        issuedLoanDataRepositoryService.save(issuedloanData);

        IssuedloanDataDTO dataDTO = new IssuedloanDataDTO();
        dataDTO.setRemainingDebt(issuedloanData.getRemainingDebt());
        dataDTO.setPaymentNo(issuedloanData.getPaymentNo());
        dataDTO.setPaymentDate(issuedloanData.getPaymentDate());
        dataDTO.setAmountOfPayment(issuedloanData.getAmountOfPayment());
        dataDTO.setInterestCharges(issuedloanData.getInterestCharges());
        dataDTO.setMainDebt(issuedloanData.getMainDebt());
        dataDTO.setId(issuedloanData.getId());

        return ResponseEntity.ok(ResponseDTO.of(dataDTO, "successfully added"));
    }
}
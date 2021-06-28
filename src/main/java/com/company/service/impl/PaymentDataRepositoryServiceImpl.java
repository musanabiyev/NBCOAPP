package com.company.service.impl;

import com.company.dao.PaymentDataRepository;
import com.company.entity.PaymentData;
import com.company.service.inter.PaymentDataRepositoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PaymentDataRepositoryServiceImpl implements PaymentDataRepositoryServiceInter {

    @Autowired
    private PaymentDataRepository paymentDataRepository;

    @Override
    public boolean save(PaymentData paymentData) {
        paymentDataRepository.save(paymentData);
        return true;
    }

    @Override
    public PaymentData findPaymentDataByCreditId(Integer CustomerDataId) {
        return paymentDataRepository.findPaymentDataByCreditId(CustomerDataId);
    }
}
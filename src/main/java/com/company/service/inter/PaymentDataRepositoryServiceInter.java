package com.company.service.inter;

import com.company.entity.PaymentData;

public interface PaymentDataRepositoryServiceInter {

    boolean save(PaymentData paymentData);

    PaymentData findPaymentDataByCreditId(Integer CustomerDataId);
}
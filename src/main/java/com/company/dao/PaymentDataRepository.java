package com.company.dao;

import com.company.entity.PaymentData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDataRepository extends JpaRepository<PaymentData,Integer> {

    @Query(value = "SELECT * FROM payment_data WHERE credit_id=:id" , nativeQuery = true)
    PaymentData findPaymentDataByCreditId(Integer id);
}

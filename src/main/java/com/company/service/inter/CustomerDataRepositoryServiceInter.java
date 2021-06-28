package com.company.service.inter;

import com.company.entity.CustomerData;

import java.util.Optional;

public interface CustomerDataRepositoryServiceInter {

    Optional<CustomerData> findById(Integer id);

    CustomerData findByCustomerId(Integer id);

    CustomerData findByUserId(Integer UserId);

    CustomerData save(CustomerData customerData);

}

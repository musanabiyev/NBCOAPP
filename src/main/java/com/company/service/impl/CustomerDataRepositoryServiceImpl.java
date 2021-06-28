package com.company.service.impl;

import com.company.dao.CustomerDataRepository;
import com.company.entity.CustomerData;
import com.company.service.inter.CustomerDataRepositoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CustomerDataRepositoryServiceImpl implements CustomerDataRepositoryServiceInter {

    @Autowired
    private CustomerDataRepository customerDataRepository;

    @Override
    public Optional<CustomerData> findById(Integer id) {
        return customerDataRepository.findById(id);
    }

    @Override
    public CustomerData findByCustomerId(Integer id) {
        return customerDataRepository.findByCustomerDataId(id);
    }

    @Override
    public CustomerData findByUserId(Integer UserId) {
        return null;
    }

    @Override
    public CustomerData save(CustomerData customerData) {
        return  customerDataRepository.save(customerData);
    }

}
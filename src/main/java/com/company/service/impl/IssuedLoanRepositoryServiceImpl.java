package com.company.service.impl;

import com.company.dao.IssuedLoanRepository;
import com.company.entity.IssuedLoan;
import com.company.service.inter.IssuedLoanRepositoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IssuedLoanRepositoryServiceImpl implements IssuedLoanRepositoryServiceInter {

    @Autowired
    private IssuedLoanRepository issuedLoanRepository;

    @Override
    public IssuedLoan findByIssudeId(Integer id) {
        return issuedLoanRepository.findByIssudeId(id);
    }
}
package com.company.service.impl;

import com.company.dao.IssuedLoanDataRepository;
import com.company.entity.IssuedloanData;
import com.company.service.inter.IssuedLoanDataRepositoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IssuedLoanDataRepositoryServiceImpl implements IssuedLoanDataRepositoryServiceInter {

    @Autowired
    private IssuedLoanDataRepository issuedLoanDataRepository;

    @Override
    public List<IssuedloanData> findByIssuedloanId(Integer id) {
        return issuedLoanDataRepository.findByIssuedloanId(id);
    }

    @Override
    public IssuedloanData save(IssuedloanData issuedloanData) {
        return issuedLoanDataRepository.save(issuedloanData);
    }
}
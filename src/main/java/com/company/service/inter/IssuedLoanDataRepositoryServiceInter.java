package com.company.service.inter;

import com.company.entity.IssuedloanData;

import java.util.List;

public interface IssuedLoanDataRepositoryServiceInter {

    List<IssuedloanData> findByIssuedloanId(Integer id);

    IssuedloanData save(IssuedloanData issuedloanData);

}
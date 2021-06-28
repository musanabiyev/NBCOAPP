package com.company.service.inter;

import com.company.entity.IssuedLoan;

public interface IssuedLoanRepositoryServiceInter {

    IssuedLoan findByIssudeId(Integer id);

}
package com.company.dao;

import com.company.entity.IssuedLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IssuedLoanRepository extends JpaRepository<IssuedLoan,Integer> {

    @Query(value = "SELECT * FROM issuedloan WHERE id=:id",nativeQuery = true)
    IssuedLoan findByIssudeId(Integer id);
}

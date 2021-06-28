package com.company.dao;

import com.company.entity.IssuedloanData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssuedLoanDataRepository extends JpaRepository<IssuedloanData, Integer> {

    @Query(value = "SELECT * FROM issuedloan_data WHERE issuedloan_id=:id", nativeQuery = true)
    List<IssuedloanData> findByIssuedloanId(Integer id);

}

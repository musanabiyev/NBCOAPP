package com.company.dao;

import com.company.entity.CustomerData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDataRepository extends JpaRepository<CustomerData, Integer> {

    CustomerData findCustomerDataByUserId(Integer UserId);

    @Query(value = "SELECT * FROM customer_data WHERE id=:id", nativeQuery = true)
    CustomerData findByCustomerDataId(Integer id);

}
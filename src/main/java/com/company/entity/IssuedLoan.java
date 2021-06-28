package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "issuedloan")
public class IssuedLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "start_date_of_loan")
    private Date startDateOfLoan;

    @Column(name = "end_date_of_loan")
    private Date endDateOfLoan;

    @Column(name = "duration_per_month")
    private Double durationPerMonth;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "percentage")
    private Double percentage;

    @JoinColumn(name = "customer_data", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CustomerData customerDataId;

    @OneToMany(mappedBy = "creditId")
    private List<PaymentData> paymentDataList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "issuedloanId")
    private List<IssuedloanData> issuedloanDataList;

}
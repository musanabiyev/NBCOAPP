package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "issuedloan_data")
public class IssuedloanData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "amount_of_payment")
    private Double amountOfPayment;

    @Column(name = "interest_charges")
    private Double interestCharges;

    @Column(name = "main_debt")
    private Double mainDebt;

    @Column(name = "payment_date")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    @Column(name = "payment_no")
    private Double paymentNo;

    @Column(name = "remaining_debt")
    private Double remainingDebt;

    @JoinColumn(name = "issuedloan_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private IssuedLoan issuedloanId;

}
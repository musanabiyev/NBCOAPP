package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment_data")
public class PaymentData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer Id;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @JoinColumn(name = "credit_id", referencedColumnName = "id")
    @ManyToOne
    private IssuedLoan creditId;
}
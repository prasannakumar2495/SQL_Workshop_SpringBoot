package com.example.sqlworkshop.SQL.Workshop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoansNewTable {
    @Id
    @Column(name = "loan_id")
    @GeneratedValue
    private long loanId;
    @Column
    private String loanStatus;
    @Column
    private long totalAmountPaid;
    @Column
    private long totalLoanAmount;
    @Column
    private Boolean autoDebit;
    @Column
    private Boolean NOC;
    @Column
    private String dateOfSanction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private LoanTypeNewTable loanTypeNewTable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Customers customers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private EMINewTable emiNewTableList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private BankDetailsNewTable bankDetailsNewTable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private LoanOutlet loanOutlet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private PartnerCustomerNewTable partnerCustomerNewTable;

    public LoansNewTable(String closed, int i, int i1,
                         Boolean randomBoolean, Boolean randomBoolean1,
                         String valueOf) {
        loanStatus = closed;
        totalAmountPaid = i;
        totalLoanAmount = i1;
        autoDebit = randomBoolean;
        NOC = randomBoolean1;
        dateOfSanction = valueOf;
    }
}

package com.example.sqlworkshop.SQL.Workshop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanTypeNewTable {
    @Id
    @Column(name = "loan_type_id")
    @GeneratedValue
    private long loanTypeId;
    @Column
    private String loanType;
    @Column
    private float interestRate;

    @OneToMany(mappedBy = "loanTypeNewTable")
    @JsonIgnore
    private List<LoansNewTable> loansNewTableList;

    public LoanTypeNewTable(String automobile, int i1) {
        loanType = automobile;
        interestRate = i1;
    }
}

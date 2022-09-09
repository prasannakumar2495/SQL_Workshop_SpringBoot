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
public class LoanOutlet {
    @Id
    @Column(name = "loan_outlet_id")
    @GeneratedValue
    private long loanOutletId;
    @Column
    private String outletName;
    @Column
    private String location;

    @OneToMany(mappedBy = "loanOutlet")
    @JsonIgnore
    private List<LoansNewTable> loansNewTableList;

    public LoanOutlet(String hgs, String generateRandom) {
        outletName = hgs;
        location = generateRandom;
    }
}

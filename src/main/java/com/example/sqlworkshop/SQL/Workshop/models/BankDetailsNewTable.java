package com.example.sqlworkshop.SQL.Workshop.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankDetailsNewTable {
    @Id
    @Column(name = "bank_account_number")
    @GeneratedValue
    private long bankAccountNumber;
    @Column
    private String accountType;
    @Column
    private String branchName;
    @Column
    private String ifscCode;

    @OneToMany(mappedBy = "bankDetailsNewTable", cascade = CascadeType.ALL)
    private List<LoansNewTable> loansNewTableList;

    public BankDetailsNewTable(String generateRandom, String generateRandom1, String generateRandom2) {
        accountType = generateRandom;
        branchName = generateRandom1;
        ifscCode = generateRandom2;
    }
}

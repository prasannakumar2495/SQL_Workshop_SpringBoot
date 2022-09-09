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
public class EMINewTable {
    @Id
    @Column(name = "emi_id")
    @GeneratedValue
    private long emiId;
    @Column
    private long emiAmount;
    @Column
    private String emiDueDate;

    @OneToMany(mappedBy = "emiNewTableList", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<LoansNewTable> loansNewTable;

    @OneToMany(mappedBy = "emiNewTable")
    private List<PenaltyNewTable> penaltyNewTable;

    @OneToMany(mappedBy = "emiNewTable")
    @JsonIgnore
    private List<Payments> paymentsList;

    public EMINewTable(long longNumber, String valueOf) {
        emiAmount = longNumber;
        emiDueDate = valueOf;
    }
}

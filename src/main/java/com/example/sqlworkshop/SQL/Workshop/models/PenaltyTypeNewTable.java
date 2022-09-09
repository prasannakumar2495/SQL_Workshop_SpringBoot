package com.example.sqlworkshop.SQL.Workshop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PenaltyTypeNewTable {
    @Id
    @Column(name = "penalty_type_id")
    @GeneratedValue
    private long penaltyTypeId;
    @Column
    private String penaltyType;
    @Column
    private long penaltyAmount;
    @Column
    private float penaltyInterest;

    @OneToMany(mappedBy = "penaltyTypeNewTable")
    @JsonIgnore
    private List<PenaltyNewTable> penaltyNewTableList;

    public PenaltyTypeNewTable(String late_pay, long longNumber, float i) {
        penaltyType = late_pay;
        penaltyAmount = longNumber;
        penaltyInterest = i;
    }
}

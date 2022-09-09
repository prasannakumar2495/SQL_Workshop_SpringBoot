package com.example.sqlworkshop.SQL.Workshop.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PenaltyNewTable {
    @Id
    @Column(name = "penalty_id")
    @GeneratedValue
    private long penaltyId;
    @Column
    private String penaltyType;
    @Column
    private long penaltyAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    private EMINewTable emiNewTable;

    @ManyToOne(fetch = FetchType.LAZY)
    private PenaltyTypeNewTable penaltyTypeNewTable;

    @OneToMany(mappedBy = "penaltyNewTable")
    private List<Payments> paymentsList;

    public PenaltyNewTable(String generateRandom, long longNumber) {
        penaltyType = generateRandom;
        penaltyAmount = longNumber;
    }
}

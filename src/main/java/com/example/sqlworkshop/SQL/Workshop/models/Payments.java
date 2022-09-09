package com.example.sqlworkshop.SQL.Workshop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payments {

    @Id
    @GeneratedValue
    private long paymentId;

    @Column
    private String paymentMode;
    @Column
    private long paymentAmount;
    @Column
    private String paymentDate;
    @Column
    private String paymentStatus;
    @Column
    private String paymentType;

    @ManyToOne(fetch = FetchType.LAZY)
    private PaymentModeNewTable paymentModeNewTable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private EMINewTable emiNewTable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private PenaltyNewTable penaltyNewTable;

    public Payments(String generateRandom, long longNumber,
                    String valueOf, String randomPaymentStatus,
                    String randomPaymentTypeMode) {
        paymentMode = generateRandom;
        paymentAmount = longNumber;
        paymentDate = valueOf;
        paymentStatus = randomPaymentStatus;
        paymentType = randomPaymentTypeMode;
    }
}

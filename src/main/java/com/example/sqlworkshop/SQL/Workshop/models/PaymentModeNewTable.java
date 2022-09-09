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
public class PaymentModeNewTable {
    @Id
    @Column(name = "payment_mode_id")
    @GeneratedValue
    private long paymentModeId;
    @Column
    private String paymentMode;

    @OneToMany(mappedBy = "paymentModeNewTable")
    @JsonIgnore
    private List<Payments> paymentsList;

    public PaymentModeNewTable(String online) {
        paymentMode = online;
    }
}

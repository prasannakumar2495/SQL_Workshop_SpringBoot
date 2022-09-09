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
public class PartnerCustomerNewTable {
    @Id
    @Column(name = "partner_customer_id")
    @GeneratedValue
    private long partnerCustomerId;
    @Column
    private String partnerCustomerName;

    @OneToMany(mappedBy = "partnerCustomerNewTable")
    @JsonIgnore
    private List<LoansNewTable> loansNewTableList;

    public PartnerCustomerNewTable(String generateRandom) {
        partnerCustomerName = generateRandom;
    }
}

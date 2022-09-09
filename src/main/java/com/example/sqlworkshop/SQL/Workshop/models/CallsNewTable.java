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
public class CallsNewTable {
    @Id
    @Column(name = "calls_id")
    @GeneratedValue
    private long callsId;
    @Column
    private String startTime;
    @Column
    private String endTime;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Customers> customersList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private CallCenters callCenters;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Employees employees;

    @OneToMany(mappedBy = "callsNewTable")
    @JsonIgnore
    private List<QueriesNewTable> queriesNewTableList;

    public CallsNewTable(String valueOf, String valueOf1) {
        startTime = valueOf;
        endTime = valueOf1;
    }
}

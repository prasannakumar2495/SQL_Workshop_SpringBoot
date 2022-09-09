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
public class CallCenters {

    @Id
    @Column(name = "call_center_id")
    @GeneratedValue
    private long callCenterId;
    @Column
    private String callCenterName;

    @OneToMany(mappedBy = "callCenters")
    @JsonIgnore
    private List<Employees> employeesList;

    @OneToMany(mappedBy = "callCenters")
    @JsonIgnore
    private List<CallsNewTable> callsNewTableList;

    public CallCenters(String generateRandom) {
        callCenterName = generateRandom;
    }
}

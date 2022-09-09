package com.example.sqlworkshop.SQL.Workshop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employees {

    @Id
    @Column(name = "employee_id")
    @GeneratedValue
    private long employeeId;
    @Column
    private String employeeName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private CallCenters callCenters;

    @OneToMany(mappedBy = "employees")
    @JsonIgnore
    private List<CallsNewTable> callsNewTableList;

    public Employees(String generateRandom) {
        employeeName = generateRandom;
    }
}

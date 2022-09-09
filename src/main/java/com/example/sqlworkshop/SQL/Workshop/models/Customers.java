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
public class Customers {

    @Id
    @GeneratedValue
    private int idcustomer;
    @Column
    private String firstname;
    @Column
    private String secondname;
    @Column
    private String regphone;
    @Column
    private String alternatenumber;
    @Column
    private String emailid;
    @Column
    private String housenum;
    @Column
    private String area;
    @Column
    private String locality;
    @Column
    private String city;
    @Column
    private String pin;

    @OneToMany(mappedBy = "customers")
    @JsonIgnore
    private List<LoansNewTable> loansNewTableList;

    @ManyToMany(mappedBy = "customersList")
    @JsonIgnore
    private List<CallsNewTable> callsNewTableList;

    public Customers(
            String generateRandom, String generateRandom1, String valueOf,
            String valueOf1, String generateRandom2, String generateRandom3,
            String generateRandom4, String generateRandom5,
            String generateRandom6, String generateRandom7) {
        firstname = generateRandom;
        secondname = generateRandom1;
        regphone = valueOf;
        alternatenumber = valueOf1;
        emailid = generateRandom2;
        housenum = generateRandom3;
        area = generateRandom4;
        locality = generateRandom5;
        city = generateRandom6;
        pin = generateRandom7;
    }
}

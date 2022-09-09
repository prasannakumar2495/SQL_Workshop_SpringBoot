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
public class QueryType {
    @Id
    @Column(name = "query_type_id")
    @GeneratedValue
    private long queryTypeId;
    @Column
    private String queryDescription;

    @OneToMany(mappedBy = "queryType")
    @JsonIgnore
    private List<QueriesNewTable> queriesNewTableList;

    public QueryType(String generateRandom) {
        queryDescription = generateRandom;
    }
}

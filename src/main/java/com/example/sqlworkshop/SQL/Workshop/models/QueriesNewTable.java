package com.example.sqlworkshop.SQL.Workshop.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QueriesNewTable {
    @Id
    @Column(name = "queries_id")
    @GeneratedValue
    private long queriesId;
    @Column
    private String statusQuery;

    @ManyToOne(fetch = FetchType.LAZY)
    private CallsNewTable callsNewTable;

    @ManyToOne(fetch = FetchType.LAZY)
    private QueryType queryType;

    public QueriesNewTable(String randomQueryStatus) {
        statusQuery = randomQueryStatus;
    }
}

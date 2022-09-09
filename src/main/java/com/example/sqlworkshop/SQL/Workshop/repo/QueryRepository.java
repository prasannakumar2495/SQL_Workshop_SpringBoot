package com.example.sqlworkshop.SQL.Workshop.repo;

import com.example.sqlworkshop.SQL.Workshop.models.QueriesNewTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueryRepository extends JpaRepository<QueriesNewTable, Long> {
}

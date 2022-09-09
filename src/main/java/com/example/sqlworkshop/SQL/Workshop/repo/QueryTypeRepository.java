package com.example.sqlworkshop.SQL.Workshop.repo;

import com.example.sqlworkshop.SQL.Workshop.models.CallCenters;
import com.example.sqlworkshop.SQL.Workshop.models.QueryType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueryTypeRepository extends JpaRepository<QueryType, Long> {
}

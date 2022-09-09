package com.example.sqlworkshop.SQL.Workshop.repo;

import com.example.sqlworkshop.SQL.Workshop.models.CallCenters;
import com.example.sqlworkshop.SQL.Workshop.models.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CallCentersRepository extends JpaRepository<CallCenters, Long> {
}

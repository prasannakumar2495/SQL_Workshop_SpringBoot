package com.example.sqlworkshop.SQL.Workshop.repo;

import com.example.sqlworkshop.SQL.Workshop.models.CallCenters;
import com.example.sqlworkshop.SQL.Workshop.models.LoanOutlet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanOutletRepository extends JpaRepository<LoanOutlet, Long> {
}

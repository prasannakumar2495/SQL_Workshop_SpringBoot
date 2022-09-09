package com.example.sqlworkshop.SQL.Workshop.repo;

import com.example.sqlworkshop.SQL.Workshop.models.BankDetailsNewTable;
import com.example.sqlworkshop.SQL.Workshop.models.PenaltyTypeNewTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PenaltyTypeRepository extends JpaRepository<PenaltyTypeNewTable, Long> {
}

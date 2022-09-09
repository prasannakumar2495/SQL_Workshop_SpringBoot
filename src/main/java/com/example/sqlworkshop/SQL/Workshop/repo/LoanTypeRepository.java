package com.example.sqlworkshop.SQL.Workshop.repo;

import com.example.sqlworkshop.SQL.Workshop.models.BankDetailsNewTable;
import com.example.sqlworkshop.SQL.Workshop.models.LoanTypeNewTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanTypeRepository extends JpaRepository<LoanTypeNewTable, Long> {
}

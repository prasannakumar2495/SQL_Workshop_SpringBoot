package com.example.sqlworkshop.SQL.Workshop.repo;

import com.example.sqlworkshop.SQL.Workshop.models.BankDetailsNewTable;
import com.example.sqlworkshop.SQL.Workshop.models.EMINewTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EMIRepository extends JpaRepository<EMINewTable, Long> {
}

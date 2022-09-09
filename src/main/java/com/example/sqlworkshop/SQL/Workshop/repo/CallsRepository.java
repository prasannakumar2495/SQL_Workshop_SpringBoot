package com.example.sqlworkshop.SQL.Workshop.repo;

import com.example.sqlworkshop.SQL.Workshop.models.BankDetailsNewTable;
import com.example.sqlworkshop.SQL.Workshop.models.CallsNewTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CallsRepository extends JpaRepository<CallsNewTable, Long> {
}

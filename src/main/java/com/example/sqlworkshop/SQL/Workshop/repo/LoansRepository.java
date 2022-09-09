package com.example.sqlworkshop.SQL.Workshop.repo;

import com.example.sqlworkshop.SQL.Workshop.models.LoansNewTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoansRepository extends JpaRepository<LoansNewTable, Long> {
}

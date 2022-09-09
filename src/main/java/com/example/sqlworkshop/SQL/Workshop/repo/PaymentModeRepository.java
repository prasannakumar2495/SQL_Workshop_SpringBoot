package com.example.sqlworkshop.SQL.Workshop.repo;

import com.example.sqlworkshop.SQL.Workshop.models.BankDetailsNewTable;
import com.example.sqlworkshop.SQL.Workshop.models.PaymentModeNewTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentModeRepository extends JpaRepository<PaymentModeNewTable, Long> {
}

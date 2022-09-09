package com.example.sqlworkshop.SQL.Workshop.repo;

import com.example.sqlworkshop.SQL.Workshop.models.BankDetailsNewTable;
import com.example.sqlworkshop.SQL.Workshop.models.PartnerCustomerNewTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerCustomerRepository extends JpaRepository<PartnerCustomerNewTable, Long> {
}

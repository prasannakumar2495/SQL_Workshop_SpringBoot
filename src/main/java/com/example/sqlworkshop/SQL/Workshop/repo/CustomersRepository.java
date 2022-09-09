package com.example.sqlworkshop.SQL.Workshop.repo;

import com.example.sqlworkshop.SQL.Workshop.models.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers, Integer> {
}

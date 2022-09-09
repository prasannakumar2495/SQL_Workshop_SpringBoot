package com.example.sqlworkshop.SQL.Workshop.repo;

import com.example.sqlworkshop.SQL.Workshop.models.CallCenters;
import com.example.sqlworkshop.SQL.Workshop.models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employees, Long> {
}

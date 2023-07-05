package com.papyrusdocs.employeeservice.repository;

import com.papyrusdocs.employeeservice.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
}

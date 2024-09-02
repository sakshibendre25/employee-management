package com.sakshi.Employee_Management.System.repository;

import com.sakshi.Employee_Management.System.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}

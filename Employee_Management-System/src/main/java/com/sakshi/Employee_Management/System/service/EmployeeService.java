package com.sakshi.Employee_Management.System.service;

import com.sakshi.Employee_Management.System.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public Employee addEmployee(Employee employee);

    public String removeEmployee(int id);

    public Optional <Employee> findEmployeeById(int id);

    public List<Employee> getAllEmployee();

    public String updateEmployee(int id);



    
}

package com.sakshi.Employee_Management.System.serviceImpl;

import com.sakshi.Employee_Management.System.entity.Employee;
import com.sakshi.Employee_Management.System.repository.EmployeeRepository;
import com.sakshi.Employee_Management.System.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;



    @Override
    public Employee addEmployee(Employee employee) {
       Employee emp =  employeeRepository.save(employee);

        return emp;
    }

    @Override
    public String removeEmployee(int id) {
        employeeRepository.deleteById(id);
        return "Delete data sucessfully!!";
    }

    @Override
    public Optional<Employee> findEmployeeById(int id) {
       Optional<Employee> emp = employeeRepository.findById(id);

        if(emp.isPresent()) {
            return emp;
        } else {
            return  null;
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> empList= employeeRepository.findAll();
        return empList;
    }

    @Override
    public String updateEmployee(int id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        if (emp.isPresent()) {
            Employee employee = new Employee();
            employeeRepository.save(employee);
            return "updated sucessfully!!";
        } else {
            return "Employee not found";
        }
    }
}

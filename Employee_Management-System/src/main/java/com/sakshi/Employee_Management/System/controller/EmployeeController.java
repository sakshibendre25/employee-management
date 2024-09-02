package com.sakshi.Employee_Management.System.controller;

import com.sakshi.Employee_Management.System.entity.Employee;
import com.sakshi.Employee_Management.System.repository.EmployeeRepository;
import com.sakshi.Employee_Management.System.serviceImpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    private EmployeeServiceImpl empservice;


    @GetMapping("/home")
    public String homePage() {
        return "Welcome to Employee Management";
    }


    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {

        Employee emp = empservice.addEmployee(employee);
        return new  ResponseEntity<Employee>(emp, HttpStatus.CREATED);
    }


    @DeleteMapping("/removeEmployee/{id}")
    public ResponseEntity<String> removeEmployee(@PathVariable int id) {
        empservice.removeEmployee(id);
        return  new ResponseEntity<String>("Remove Succesfully",HttpStatus.ACCEPTED);

    }

    @GetMapping("/findEmployee/{id}")
    public ResponseEntity<Optional<Employee>>findEmployeeById(@PathVariable int id) {
        Optional<Employee> employee = empservice.findEmployeeById(id);
        return new ResponseEntity<Optional<Employee>>(employee,HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> listOfEmployees() {
        List<Employee> lEmp = empservice.getAllEmployee();
        return new ResponseEntity<List<Employee>>(lEmp,HttpStatus.ACCEPTED);

    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable int id) {
        empservice.updateEmployee(id);
        return  new ResponseEntity<String>("Update Succesfully",HttpStatus.ACCEPTED);

    }
}

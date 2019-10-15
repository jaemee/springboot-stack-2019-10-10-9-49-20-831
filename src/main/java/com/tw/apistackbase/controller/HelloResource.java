package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by jxzhong on 18/08/2017.
 */
@RestController
@RequestMapping("/employees")
public class HelloResource {

    private List<Employee> employeeList = new ArrayList<>();
    private final Logger log = Logger.getLogger(this.getClass().getName());


    @GetMapping(path = "/viewAll", produces = {"application/json"})
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public List<Employee> createEmployee(@RequestBody Employee employee) {
        employeeList.add(employee);
        return  employeeList;
    }

    @DeleteMapping(path = "/delete", consumes = "application/json", produces = "application/json")
    public List<Employee> deleteEmployee(@RequestBody Employee employee) {
        EmployeeService employeeService = new EmployeeService(employeeList);
        employeeList.removeAll(employeeService.getEmployeesById(employee.getId()));
        return  employeeList;
    }

}

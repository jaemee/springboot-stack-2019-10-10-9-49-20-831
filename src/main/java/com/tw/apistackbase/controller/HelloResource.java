package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.BindException;
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
    private  EmployeeService employeeService = new EmployeeService(employeeList);
    private final Logger log = Logger.getLogger(this.getClass().getName());


    @GetMapping(path = "/viewAll", produces = {"application/json"})
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public List<Employee> createEmployee(@RequestBody Employee employee) {
        if(employeeService.getEmployeesById(employee.getId())!=null){
            employeeList.add(employee);
            return employeeList;
        }
        return null;
    }

    @DeleteMapping(path = "/delete", consumes = "application/json", produces = "application/json")
    public List<Employee> deleteEmployee(@RequestBody Employee employee) {
        EmployeeService employeeService = new EmployeeService(employeeList);
        employeeList.removeAll(employeeService.getEmployeesById(employee.getId()));
        return  employeeList;
    }

    @PutMapping (path = "/update", consumes = "application/json", produces = "application/json")
    public List<Employee> updateEmployee(@RequestBody Employee employee) {
        EmployeeService employeeService = new EmployeeService(employeeList);
        Employee currentEmployee = employeeService.getEmployeesById(employee.getId()).get(0);
        employeeList.set(employeeList.indexOf(currentEmployee), employee);
        return  employeeList;
    }

}

package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {

    private List<Employee> employeeList;

    public EmployeeService(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Employee> getEmployeesById(int id){
        return employeeList.stream()
                .filter(employee -> employee.getId()==id)
                .collect(Collectors.toList());
    }
}

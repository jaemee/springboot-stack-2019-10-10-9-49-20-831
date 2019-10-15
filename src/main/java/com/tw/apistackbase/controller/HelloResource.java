package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
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


    @GetMapping(path = "/{userName}", produces = {"application/json"})
    public ResponseEntity<String> getAll(@PathVariable String userName) {

        return ResponseEntity.ok("Hello:" + userName);
    }

//    @ResponseBody
//    @GetMapping(path = "/test-response-body/{name}", produces = {"application/json"})
//    public ResponseTransfer postResponseController (
//            @RequestBody LoginForm loginForm) {
//        return new ResponseTransfer("Thanks "+ loginForm.getUserName() +" For Requesting!!!");
//    }

    @PostMapping(path = "/create-employee", consumes = "application/json", produces = "application/json")
    public List<Employee> createEmployee(@RequestBody Employee employee) {
        employeeList.add(employee);
        return  employeeList;
    }

}

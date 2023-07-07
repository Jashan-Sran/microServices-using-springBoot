package com.srantech.employee.controller;

import com.srantech.employee.response.EmployeeResponse;
import com.srantech.employee.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee/")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id){

        EmployeeResponse employeeResponse = employeeService.getEmployeeDetails(id);

        return new ResponseEntity<EmployeeResponse>(employeeResponse,HttpStatus.OK);
    }
}

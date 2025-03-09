package com.koksao.shop.controllers;

import com.koksao.shop.domain.Employee;
import com.koksao.shop.domain.dto.EmployeeFilterRequest;
import com.koksao.shop.domain.dto.EmployeeResponse;
import com.koksao.shop.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping(path = "/employee", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAllEmployeesBasicInfo() {
        List<EmployeeResponse> employeeList = employeeService.employeesBasicInfo();
        return ResponseEntity.status(HttpStatus.OK).body(employeeList);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> getByFilters(@RequestBody EmployeeFilterRequest employeeFilterRequest) {
        List<Employee> employees = employeeService.searchByFilters(employeeFilterRequest);
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

}

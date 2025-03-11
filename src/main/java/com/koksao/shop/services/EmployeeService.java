package com.koksao.shop.services;

import com.koksao.shop.domain.Employee;
import com.koksao.shop.domain.dto.request.filter.EmployeeFilterRequest;
import com.koksao.shop.domain.dto.response.EmployeeResponse;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<EmployeeResponse> employeesBasicInfo();

    Employee save(Employee employee);

    List<Employee> findAll();

    Optional<Employee> findById(Long id);

    List<Employee> searchByFilters(EmployeeFilterRequest employeeFilterRequest);

}

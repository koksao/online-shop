package com.koksao.shop.services.impl;

import com.koksao.shop.domain.Employee;
import com.koksao.shop.domain.dto.request.filter.EmployeeFilterRequest;
import com.koksao.shop.domain.dto.response.EmployeeResponse;
import com.koksao.shop.repositories.EmployeeRepository;
import com.koksao.shop.repositories.specifications.EmployeeSpecification;
import com.koksao.shop.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeSpecification employeeSpecification;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return StreamSupport.stream(employeeRepository
                                .findAll()
                                .spliterator(),
                        false)
                .toList();
    }

    @Override
    public List<EmployeeResponse> employeesBasicInfo() {
        return employeeRepository.employeesBasicInfo();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> searchByFilters(EmployeeFilterRequest employeeFilterRequest) {
        List<Employee> filteredEmployees = employeeRepository.findAll(employeeSpecification
                .conditionalSearchForEmployee(employeeFilterRequest));
        return filteredEmployees;
    }

}

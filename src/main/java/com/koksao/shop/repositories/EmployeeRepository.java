package com.koksao.shop.repositories;

import com.koksao.shop.domain.Employee;
import com.koksao.shop.domain.dto.EmployeeResponse;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {

    @Query("SELECT new com.koksao.shop.domain.dto.EmployeeResponse( e.id, e.firstName, e.lastName, e.email, e.telephone, e.position) FROM Employee e ")
    List<EmployeeResponse> employeesBasicInfo();

    List<Employee> findAll(Specification<Employee> specification);

    List<Employee> findAll();

}

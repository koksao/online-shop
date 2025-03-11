package com.koksao.shop.repositories.specifications;

import com.koksao.shop.domain.Employee;
import com.koksao.shop.domain.Membership;
import com.koksao.shop.domain.Position;
import com.koksao.shop.domain.dto.request.filter.EmployeeFilterRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class EmployeeSpecification {

    public Specification<Employee> byFirstName(String firstName) {
        return (root, query, cb) ->
                cb.equal(
                        root.get("firstName"),
                        firstName
                );
    }

    public Specification<Employee> byLastName(String lastName) {
        return (root, query, cb) ->
                cb.equal(
                        root.get("lastName"),
                        lastName
                );
    }

    public Specification<Employee> byCity(String city) {
        return (root, query, cb) ->
                cb.equal(
                        root.get("address").get("city"),
                        city
                );
    }

    public Specification<Employee> byEmail(String email) {
        return (root, query, cb) ->
                cb.equal(
                        root.get("email"),
                        email
                );
    }

    public Specification<Employee> byMembership(Membership membership) {
        return (root, query, cb) ->
                cb.equal(
                        root.get("membership"),
                        membership
                );
    }

    public Specification<Employee> byPosition(Position position) {
        return (root, query, cb) ->
                cb.equal(
                        root.get("position"),
                        position
                );
    }

    public Specification<Employee> byId(Long id) {
        return (root, query, cb) ->
                cb.equal(
                        root.get("id"),
                        id
                );
    }

    public Specification<Employee> conditionalSearchForEmployee(EmployeeFilterRequest employeeFilterRequest) {

        Specification<Employee> spec = Specification.where(null);

        if(employeeFilterRequest.getId() != null) {
            spec = spec.and(byId(employeeFilterRequest.getId()));
        }
        if (employeeFilterRequest.getFirstName() != null) {
            spec = spec.and(byFirstName(employeeFilterRequest.getFirstName()));
        }
        if (employeeFilterRequest.getLastName() != null) {
            spec = spec.and(byLastName(employeeFilterRequest.getLastName()));
        }
        if (employeeFilterRequest.getEmail() != null) {
            spec = spec.and(byEmail(employeeFilterRequest.getEmail()));
        }
        if (employeeFilterRequest.getMembership() != null) {
            spec = spec.and(byMembership(employeeFilterRequest.getMembership()));
        }
        if (employeeFilterRequest.getPosition() != null) {
            spec = spec.and(byPosition(employeeFilterRequest.getPosition()));
        }
        if (employeeFilterRequest.getCity() != null) {
            spec = spec.and(byCity(employeeFilterRequest.getCity()));
        }

        return spec;
    }


}

package com.koksao.shop.domain.dto;

import com.koksao.shop.domain.Position;
import com.koksao.shop.repositories.EmployeeRepository;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeResponse {

    public Long id;

    public String firstName;

    public String lastName;

    public String email;

    public String telephone;

    @Enumerated(EnumType.STRING)
    public Position position;


}

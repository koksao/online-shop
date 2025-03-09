package com.koksao.shop.domain.dto;

import com.koksao.shop.domain.Membership;
import com.koksao.shop.domain.Position;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeFilterRequest {

    String firstName;

    String lastName;

    String email;

    Membership membership;

    Position position;

    String city;

}

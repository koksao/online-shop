package com.koksao.shop.domain.dto.request.filter;

import com.koksao.shop.domain.Membership;
import com.koksao.shop.domain.Position;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeFilterRequest {

    Long id;

    String firstName;

    String lastName;

    String email;

    Membership membership;

    Position position;

    String city;

}

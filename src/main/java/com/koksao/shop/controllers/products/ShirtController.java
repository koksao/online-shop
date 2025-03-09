package com.koksao.shop.controllers.products;

import com.koksao.shop.domain.dto.ShirtFilterRequest;
import com.koksao.shop.domain.products.Shirt;
import com.koksao.shop.services.ShirtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shirts")
public class ShirtController {

    @Autowired
    ShirtService shirtService;

    @PostMapping(value = "/shirt", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Shirt> createShirt(@RequestBody Shirt shirt) {
        Shirt savedshirt = shirtService.save(shirt);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedshirt);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Shirt>> getByFilters(@RequestBody ShirtFilterRequest shirtFilterRequest) {
        List<Shirt> shirts = shirtService.findAll(shirtFilterRequest);
        return ResponseEntity.status(HttpStatus.OK).body(shirts);
    }

}

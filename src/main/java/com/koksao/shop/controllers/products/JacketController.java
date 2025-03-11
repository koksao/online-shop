package com.koksao.shop.controllers.products;
import com.koksao.shop.domain.dto.request.filter.JacketFilterRequest;
import com.koksao.shop.domain.products.Jacket;
import com.koksao.shop.services.JacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jackets")
public class JacketController {

    @Autowired
    JacketService jacketService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Jacket> createJacket(@RequestBody Jacket jacket) {
        Jacket savedJacket = jacketService.save(jacket);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedJacket);
    }

    @PostMapping(value = "/filter", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Jacket>> getByFilters(@RequestBody JacketFilterRequest jacketFilterRequest){
        List<Jacket> list = jacketService.findAll(jacketFilterRequest);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

}

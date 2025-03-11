package com.koksao.shop.controllers.products;

import com.koksao.shop.domain.dto.request.filter.DressFilterRequest;
import com.koksao.shop.domain.products.Dress;
import com.koksao.shop.services.DressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dresses")
public class DressController {

    @Autowired
    DressService dressService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dress> createDress(@RequestBody Dress dress){
        Dress savedDress = dressService.save(dress);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDress);
    }

    @PostMapping(path = "/filter",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Dress>> getByFilters(@RequestBody DressFilterRequest dressFilterRequest){
        List<Dress> dresses = dressService.findAll(dressFilterRequest);
        return ResponseEntity.status(HttpStatus.OK).body(dresses);
    }

}

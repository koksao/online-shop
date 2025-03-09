package com.koksao.shop.controllers.products;

import com.koksao.shop.domain.products.Pants;
import com.koksao.shop.services.PantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pants")
public class PantsController {

    @Autowired
    PantsService pantsService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pants> createPants(@RequestBody Pants pants) {
        Pants savedPants = pantsService.save(pants);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPants);
    }

    @GetMapping
    public ResponseEntity<List<Pants>> getPants() {
        List<Pants> savedPants = pantsService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(savedPants);
    }
}

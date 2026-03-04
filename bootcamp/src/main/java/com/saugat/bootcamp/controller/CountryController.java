package com.saugat.bootcamp.controller;

import com.saugat.bootcamp.model.Country;
import com.saugat.bootcamp.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/country")
public class CountryController {

    private final CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @GetMapping("/ping")
    public String ping(){
        return "Hello from CountryCountroller";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> get(@PathVariable Long id){
        Country country = service.get(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(country);
    }

    @GetMapping
    public ResponseEntity<List<Country>> get(){
        List<Country> countryList = service.get();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(countryList);
    }

    @PostMapping()
    public ResponseEntity<Country> create(@RequestBody Country obj){
        Country country = service.create(obj);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(country);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Country> edit(@PathVariable Long id, @RequestBody Country obj){
        Country country = service.edit(id, obj);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(country);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(null);
    }
}

package com.example.gumpback.controller;

import com.example.gumpback.dto.CountryDTO;
import com.example.gumpback.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/country")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping
    public ResponseEntity<CountryDTO> save (@RequestBody CountryDTO countryDTO){
        return ResponseEntity.ok(countryService.save(countryDTO));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true) Long id){
        return ResponseEntity.ok(countryService.delete(id));
    }

    @GetMapping("/all")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(countryService.findAll());
    }
}

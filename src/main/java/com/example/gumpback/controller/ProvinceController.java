package com.example.gumpback.controller;

import com.example.gumpback.dto.ProvinceDTO;
import com.example.gumpback.entity.Province;
import com.example.gumpback.service.ProvinceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/province")
public class ProvinceController {
    private final ProvinceService provinceService;

    public ProvinceController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @PostMapping
    public ResponseEntity<ProvinceDTO> save(@RequestBody ProvinceDTO provinceDTO){
        return ResponseEntity.ok(provinceService.save(provinceDTO));
    }

    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true) Long id){
        return ResponseEntity.ok(provinceService.delete(id));
    }

    @GetMapping("/all")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(provinceService.findAll());
    }

}

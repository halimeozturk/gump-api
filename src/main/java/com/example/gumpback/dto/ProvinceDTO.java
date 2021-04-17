package com.example.gumpback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceDTO implements Serializable {
    private long id;
    private String name;
    private CountryDTO countryName;
}

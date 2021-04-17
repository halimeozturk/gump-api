package com.example.gumpback.dto;

import com.example.gumpback.entity.Province;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryDTO implements Serializable {
    private long id;
    private String name;
    private List<ResponseProvinceDTO> provinces;
}

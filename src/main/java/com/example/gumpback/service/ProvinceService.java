package com.example.gumpback.service;

import com.example.gumpback.dto.ProvinceDTO;
import com.example.gumpback.entity.Province;
import com.example.gumpback.repository.ProvinceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProvinceService {
    private final ProvinceRepository provinceRepository;
    private final ModelMapper modelMapper;

    public ProvinceService(ProvinceRepository provinceRepository, ModelMapper modelMapper) {
        this.provinceRepository = provinceRepository;
        this.modelMapper = modelMapper;
    }

    public ProvinceDTO save(ProvinceDTO provinceDTO){
        Province provinceCheck = provinceRepository.getByName(provinceDTO.getName());
        if(provinceCheck != null){
            throw new IllegalArgumentException("Province Already Exist");
        }

        Province province = modelMapper.map(provinceDTO,Province.class);
        province = provinceRepository.save(province);
        provinceDTO.setId(province.getId());
        return provinceDTO;
    }

    public Boolean delete(Long id){
        provinceRepository.deleteById(id);
        return true;
    }

    public ProvinceDTO[] findAll() {
        List<Province> provinceArrayList = new ArrayList<>();
        provinceRepository.findAll().forEach(i -> provinceArrayList.add(i));
        return modelMapper.map(provinceArrayList, ProvinceDTO[].class);
    }
}

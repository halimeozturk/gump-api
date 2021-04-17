package com.example.gumpback.service;

import com.example.gumpback.dto.CountryDTO;
import com.example.gumpback.entity.Country;
import com.example.gumpback.repository.CountryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {
    private final CountryRepository countryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CountryService(CountryRepository countryRepository, ModelMapper modelMapper) {
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
    }

    public CountryDTO save(CountryDTO countryDTO){
        Country countryCheck = countryRepository.getById(countryDTO.getId());
        if(countryCheck != null){
            throw new IllegalArgumentException("Country Already Exist");
        }

        Country country = modelMapper.map(countryDTO,Country.class);
        country = countryRepository.save(country);
        countryDTO.setId(country.getId());
        return countryDTO;
    }

    public Boolean delete(Long id){
        countryRepository.deleteById(id);
        return true;
    }

    public CountryDTO[] findAll() {
            List<Country> countryArrayList = new ArrayList<>();
        countryRepository.findAll().forEach(i -> countryArrayList.add(i));
        return modelMapper.map(countryArrayList, CountryDTO[].class);
    }
}

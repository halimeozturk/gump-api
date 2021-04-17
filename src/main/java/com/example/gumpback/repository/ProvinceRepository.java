package com.example.gumpback.repository;

import com.example.gumpback.entity.Province;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceRepository extends JpaRepository<Province,Long> {
    List<Province> findAll(Sort sort);

    Province getByName(String name);
}

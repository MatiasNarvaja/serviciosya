

package com.capgemeini.serviciosya.jpa.repositories.jpa;


import com.capgemeini.serviciosya.jpa.entities.jpa.CountryEntity;
import com.capgemeini.serviciosya.jpa.entities.jpa.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IProvinceRepository extends JpaRepository<ProvinceEntity, Integer> {


    List<ProvinceEntity> findAllByCountryOrderByNameDesc(CountryEntity country);
}
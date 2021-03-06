
package com.capgemeini.serviciosya.jpa.repositories.jpa;


import com.capgemeini.serviciosya.jpa.entities.jpa.CityEntity;
import com.capgemeini.serviciosya.jpa.entities.jpa.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ICityRepository extends JpaRepository<CityEntity, Integer> {

    List<CityEntity> findAllByProvince(ProvinceEntity province);

    //ciudades por province y por nombre
}
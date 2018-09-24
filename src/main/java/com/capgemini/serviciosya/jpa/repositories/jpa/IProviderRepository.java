package com.capgemini.serviciosya.jpa.repositories.jpa;


import  com.capgemini.serviciosya.jpa.entities.jpa.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface IProviderRepository extends JpaRepository<ProviderEntity, Integer>{




    @Query (value = "SELECT * FROM provider WHERE prov_name LIKE ?1",
            nativeQuery = true)
    List<ProviderEntity> findAllByName(String val);


    @Query (value = "SELECT * FROM provider WHERE prov_cityid LIKE ?1",
            nativeQuery = true)
    List<ProviderEntity> findAllByCity(Integer val);

    @Query (value = "SELECT * FROM provider WHERE prov_dni LIKE ?1",
            nativeQuery = true)
    List<ProviderEntity> findAllByDNI(Integer val);


}

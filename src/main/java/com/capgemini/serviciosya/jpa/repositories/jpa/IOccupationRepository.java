package com.capgemini.serviciosya.jpa.repositories.jpa;


import  com.capgemini.serviciosya.jpa.entities.jpa.OccupationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
    public interface IOccupationRepository extends JpaRepository<OccupationEntity, Integer>{





    @Query ("FROM Occupation o WHERE o.id < :id")
    List<OccupationEntity> findAllByIdIsLessThan2(@Param("id") Integer value);

    @Query (value = "SELECT * FROM occupation WHERE occu_name LIKE ?1",
            nativeQuery = true)
    List<OccupationEntity> findAllByName(String val);

    }



package com.capgemeini.serviciosya.jpa.repositories.jpa;

import com.capgemeini.serviciosya.jpa.entities.jpa.ConsumerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IConsumerRepository extends JpaRepository<ConsumerEntity, Integer>{


    @Query (value = "SELECT * FROM consumer WHERE con_name LIKE ?1",
            nativeQuery = true)
    List<ConsumerEntity> findAllByName(String val);


    @Query (value = "SELECT * FROM provider WHERE con_cityid LIKE ?1",
            nativeQuery = true)
    List<ConsumerEntity> findAllByCity(Integer val);

    @Query (value = "SELECT * FROM provider WHERE con_dni LIKE ?1",
            nativeQuery = true)
    List<ConsumerEntity> findAllByDNI(Integer val);


}

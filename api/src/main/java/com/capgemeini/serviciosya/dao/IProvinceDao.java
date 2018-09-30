package com.capgemeini.serviciosya.dao;

import com.capgemeini.serviciosya.beans.entity.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IProvinceDao extends JpaRepository<ProvinceEntity, Integer> {



}

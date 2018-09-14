
package com.capgemeini.serviciosya.dao;


import com.capgemeini.serviciosya.beans.entity.CountryEntity;


public interface ICountryDao extends IDao<CountryEntity, Integer> {


     CountryEntity findByName (String name);
}
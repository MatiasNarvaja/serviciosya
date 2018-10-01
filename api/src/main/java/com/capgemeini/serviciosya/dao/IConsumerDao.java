package com.capgemeini.serviciosya.dao;
import com.capgemeini.serviciosya.beans.entity.ConsumerEntity;


public interface IConsumerDao extends IDao<ConsumerEntity, Integer>{

    ConsumerEntity findByEmail(String email);

    ConsumerEntity findByDNI(Integer dni);

    ConsumerEntity findByPhone(String phone);

}

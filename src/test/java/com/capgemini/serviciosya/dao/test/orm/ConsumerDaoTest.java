package com.capgemini.serviciosya.dao.test.orm;

import com.capgemini.serviciosya.beans.entity.CityEntity;
import com.capgemini.serviciosya.beans.entity.ConsumerEntity;
import com.capgemini.serviciosya.dao.IConsumerDao;
import com.capgemini.serviciosya.dao.orm.ConsumerDaoHibernate;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ConsumerDaoTest {

    private IConsumerDao dao = new ConsumerDaoHibernate();

    @Test
    public void testCreate () {

        ConsumerEntity c = new ConsumerEntity ();
        c.setName("Don");
        c.setLastName("Ramon");
        c.setDni(4215);
        c.setEmail("dorramon@hotmail.com");
        c.setPhone ("45874242");
        c.setAddress("Ciudad de Mexico");
        CityEntity city = new CityEntity();
        city.setId(5);
        c.setCity(city);
        c.setStatus(0);
        this.dao.create (c);

        Assert.assertNotNull ("Failure creating new provider.", c.getId ());
    }

    @Test
    public void testFindAll () {


        List<ConsumerEntity> list = this.dao.findAll ();

        ConsumerEntity c = list.get (0);

        list.forEach (System.out::println);

        Assert.assertFalse ("Failure find all countries.", list.isEmpty ());
    }

    @Test
    public void testFindByDNI () {

        ConsumerEntity c = this.dao.findByDNI (4215);

        Assert.assertNotNull ("Failure find by dni.", c);
    }

    @Test
    public void testFindByEmail(){
        ConsumerEntity c = this.dao.findByEmail("juan@gmail.com");
        Assert.assertNotNull ("Failure find by email.", c);

    }

    @Test
    public void  testFindByPhone (){
        ConsumerEntity c = this.dao.findByPhone("45221548");
        Assert.assertNotNull ("Failure find by phone.", c);


    }



}

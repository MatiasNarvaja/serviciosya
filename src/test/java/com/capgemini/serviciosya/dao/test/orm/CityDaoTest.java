package com.capgemini.serviciosya.dao.test.orm;

import com.capgemini.serviciosya.beans.entity.CityEntity;
import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import com.capgemini.serviciosya.dao.ICityDao;
import com.capgemini.serviciosya.dao.orm.CityDaoHibernate;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CityDaoTest {

    private ICityDao dao = new CityDaoHibernate();

    @Test
    public void testCreate () {

        CityEntity p = new CityEntity();
        ProvinceEntity c = new ProvinceEntity();
        c.setId (1);
        p.setName ("Devoto");
        p.setProvince (c);

        this.dao.create (p);

        Assert.assertNotNull ("Failure creating new City.", c.getId ());
    }
    @Test
    public void testUpdate () {

        CityEntity p = new CityEntity();
        ProvinceEntity c = new ProvinceEntity();
        c.setId (3);
        p.setId (2);
        p.setName ("devoto");
        p.setProvince (c);
        this.dao.update (p);

        Assert.assertEquals ("Failure updating City.", "caba", p.getName ());
    }

    @Test
    public void testDelete () {

        int id = 2;
        this.dao.delete (id);

        CityEntity c = this.dao.findById (id);

        Assert.assertNull ("Failure deleting City.", c);
    }
    @Test
    public void testFindAll () {

        List<CityEntity> list = this.dao.findAll ();

        list.forEach (e -> System.out.println (e.getName () + " -> " + e.getProvince ().getName ()));

        Assert.assertFalse ("Failure find all cities.", list.isEmpty ());
    }
}

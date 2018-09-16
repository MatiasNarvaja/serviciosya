package com.capgemeini.serviciosya.dao.test.orm;

import com.capgemeini.serviciosya.beans.entity.OccupationEntity;
import com.capgemeini.serviciosya.dao.IOccupationDao;
import com.capgemeini.serviciosya.dao.orm.OccupationDaoHibernate;

import org.junit.*;

import java.util.List;

public class OccupationDaoTest {

    private IOccupationDao dao = new OccupationDaoHibernate();


    @Test
    public void testCreate () {

        OccupationEntity o = new OccupationEntity ();
        o.setName("Pintor");
        o.setDescription("Pinto casas de interiores como exteriores");
        o.setParent(1);
        this.dao.create (o);

        Assert.assertNotNull ("Failure creating new occupation.", o.getId ());
    }

    @Test
    public void testUpdate () {

        OccupationEntity o = new OccupationEntity();
        // ProvinceEntity p = new ProvinceEntity ();
        //CountryEntity c = new CountryEntity ();
        o.setId (3);
        o.setName ("Albañil");
        o.setDescription("Construyo casas");
        o.setParent(3);
        this.dao.update (o);

        Assert.assertEquals ("Failure updating occupation.", "Albañil", o.getName ());
    }

    @Test
    public void testDelete () {

        int id = 2;
        this.dao.delete (id);

        OccupationEntity o = this.dao.findById (id);

        Assert.assertNull ("Failure deleting occupation.", o);
    }

    @Test
    public void testFindAll () {

        List<OccupationEntity> list = this.dao.findAll ();

       // list.forEach (e -> System.out.println (e.getName () + " -> " + e.getCountry ().getName ()));

        Assert.assertFalse ("Failure find all provinces.", list.isEmpty ());
    }





}

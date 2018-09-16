package com.capgemeini.serviciosya.dao.test.orm;

import com.capgemeini.serviciosya.beans.entity.OccupationEntity;
import com.capgemeini.serviciosya.dao.IOccupationDao;
import com.capgemeini.serviciosya.dao.orm.OccupationDaoHibernate;
import org.junit.*;

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


}

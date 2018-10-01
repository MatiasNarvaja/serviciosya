package com.capgemini.serviciosya.jpa.test;




import com.capgemeini.serviciosya.jpa.entities.jpa.OccupationEntity;
import com.capgemeini.serviciosya.jpa.repositories.jpa.IOccupationRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE , classes = JpaConfiguration.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OccupationRepositoryTest {

    @Autowired
    private IOccupationRepository repository = null;


    private final Logger logger = LoggerFactory.getLogger (OccupationRepositoryTest.class);


    public  OccupationRepositoryTest(){
        super();
    }

    @Before
    public void setup () {

        logger.info ("Creating occupations...");
        OccupationEntity[] occupations = new OccupationEntity[]  {

                new OccupationEntity (Integer.valueOf (1), "Domador de leones", "Domador de leones",1),
                new OccupationEntity (Integer.valueOf (2), "Electricista", "Instalo reparo y superviso cualquier instalacion electrica",2),
                new OccupationEntity (Integer.valueOf (3), "Constructor de muebles", "Creo muebles de cualquier tipo de madera a pedido",3),
                new OccupationEntity (Integer.valueOf (4), "Pintor", "Pinto casas de interiores como exteriores",4)

        };
        logger.debug (String.format ("Objects occupation created %s", Arrays.toString (occupations)));

        logger.debug ("Saving occupations...");
        this.repository.save (Arrays.asList (occupations));
        logger.debug (String.format ("Occupations saved %s", Arrays.toString (occupations)));
    }

    @Test
    public void testCount () {

        logger.info ("Counting occupations...");
        Long count = this.repository.count ();

        Assert.assertNotNull ("There are occupations...", count);
        Assert.assertTrue ("There are occupations...",count > 0);
    }

    @Test
    public void testGetAll () {

        logger.info ("Getting occupations...");
        List<OccupationEntity> list = this.repository.findAll ();

        Assert.assertNotNull ("There are occupations...", list);
        Assert.assertFalse ("There are occupations...",list.isEmpty ());
    }

    @Test
    public void testGetAllByName () {

        logger.info ("Getting occupations...");
        List<OccupationEntity> list = this.repository.findAllByName ("%A%");

        Assert.assertNotNull ("There are occupations...", list);
        Assert.assertFalse ("There are occupations...",list.isEmpty ());
    }

    @Test
    public void testGetOne () {

        logger.info ("Getting occupation...");
        OccupationEntity occupation = this.repository.findOne (Integer.valueOf (1));

        Assert.assertNotNull ("There is a occupation...", occupation);
        Assert.assertEquals ("There is occupation...", "Pintor", occupation.getName ());
    }

    @Test
    public void testRelease () {

        logger.info ("Deleting occupations...");
        this.repository.deleteAll ();
        logger.info ("Occupations deleted...");

        logger.info ("Getting countries...");
        List<OccupationEntity> list = this.repository.findAll ();

        Assert.assertTrue ("There are not occupations...",list.isEmpty ());
    }

    @Test
    public void testGetAllLess () {

        logger.info ("Getting occupations...");
        List<OccupationEntity> list = this.repository.findAllByIdIsLessThan2 (Integer.valueOf (3));

        Assert.assertNotNull ("There are occupations...", list);
        Assert.assertFalse ("There are occupations...",list.isEmpty ());
    }




}

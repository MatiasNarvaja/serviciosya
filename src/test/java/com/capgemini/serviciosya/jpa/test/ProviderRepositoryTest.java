package com.capgemini.serviciosya.jpa.test;

import com.capgemini.serviciosya.jpa.entities.jpa.ProviderEntity;
import com.capgemini.serviciosya.jpa.repositories.jpa.IProviderRepository;
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
public class ProviderRepositoryTest {

    @Autowired
    private IProviderRepository repository = null;
    private final Logger logger = LoggerFactory.getLogger(ProviderRepositoryTest.class);

    public  ProviderRepositoryTest(){
        super();

    }

    @Before
    public void setup () {

        logger.info ("Creating providers...");
        ProviderEntity[] providers = new ProviderEntity[]  {

                new ProviderEntity (Integer.valueOf (1), "Juan", "Sanchez",351234747,"juasan@hotmail.com","470415",1,"Rivadavia 133",1),
                new ProviderEntity (Integer.valueOf (2), "Rosa", "Garcia",123456,"rosaa@gmail.com","41240000",2,"cabildo 142",2),
                new ProviderEntity (Integer.valueOf (3), "Ariel", "ortega",10,"elburrito@gmail.com","14101410",1,"Vinito 10",1)


        };
        logger.debug (String.format ("Objects providers created %s", Arrays.toString (providers)));

        logger.debug ("Saving providers...");
        this.repository.save (Arrays.asList (providers));
        logger.debug (String.format ("providers saved %s", Arrays.toString (providers)));
    }

    @Test
    public void testCount () {

        logger.info ("Counting providers...");
        Long count = this.repository.count ();

        Assert.assertNotNull ("There are providers...", count);
        Assert.assertTrue ("There are providers...",count > 0);
    }

    @Test
    public void testGetAll () {

        logger.info ("Getting providers...");
        List<ProviderEntity> list = this.repository.findAll ();

        Assert.assertNotNull ("There are providers...", list);
        Assert.assertFalse ("There are providers...",list.isEmpty ());
    }

    @Test
    public void testGetAllByName () {

        logger.info ("Getting provider...");
        List<ProviderEntity> list = this.repository.findAllByName ("%A%");

        Assert.assertNotNull ("There are provider...", list);
        Assert.assertFalse ("There are provider...",list.isEmpty ());
    }

    @Test
    public void testGetAllForCity () {

        logger.info ("Getting provider...");
        List<ProviderEntity> list = this.repository.findAllByCity (Integer.valueOf (1));

        Assert.assertNotNull ("There are providers...", list);
        Assert.assertFalse ("There are providers...",list.isEmpty ());
    }

    @Test
    public void testGetForDNI () {

        logger.info ("Getting provider...");
        List<ProviderEntity> list = this.repository.findAllByDNI (Integer.valueOf (10));

        Assert.assertNotNull ("There are provider...", list);
        Assert.assertFalse ("There are provider...",list.isEmpty ());
    }




}

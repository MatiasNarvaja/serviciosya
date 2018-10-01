package com.capgemini.serviciosya.jpa.test;

import com.capgemeini.serviciosya.jpa.entities.jpa.ConsumerEntity;
import com.capgemeini.serviciosya.jpa.repositories.jpa.IConsumerRepository;
import com.capgemeini.serviciosya.jpa.repositories.jpa.IProviderRepository;
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

public class ConsumerRepositoryTest {

    @Autowired
    private IConsumerRepository repository = null;
    private final Logger logger = LoggerFactory.getLogger(ConsumerRepositoryTest.class);

    public  ConsumerRepositoryTest(){ super();}

    @Before
    public void setup () {

        logger.info ("Creating consumers...");
        ConsumerEntity[] consumers = new ConsumerEntity[]  {

                new ConsumerEntity (Integer.valueOf (1), "Carlos", "Perez",45841,"Carloss@hotmail.com","487411",1,"Av Siempre viva 123",1),
                new ConsumerEntity (Integer.valueOf (2), "Nahuel", "Gomez",4512,"nahuu@gmail.com","541234",2,"cabildo 444",2),
                new ConsumerEntity (Integer.valueOf (3), "Daniel", "pereiras",10,"elgallego@gmail.com","7574",1,"Galicia 457",1)


        };
        logger.debug (String.format ("Objects consumers created %s", Arrays.toString (consumers)));

        logger.debug ("Saving consumers...");
        this.repository.save (Arrays.asList (consumers));
        logger.debug (String.format ("providers saved %s", Arrays.toString (consumers)));
    }

    @Test
    public void testCount () {

        logger.info ("Counting consumers...");
        Long count = this.repository.count ();

        Assert.assertNotNull ("There are consumers...", count);
        Assert.assertTrue ("There are consumers...",count > 0);
    }

    @Test
    public void testGetAll () {

        logger.info ("Getting consumers...");
        List<ConsumerEntity> list = this.repository.findAll ();

        Assert.assertNotNull ("There are consumers...", list);
        Assert.assertFalse ("There are consumers...",list.isEmpty ());
    }

    @Test
    public void testGetAllByName () {

        logger.info ("Getting provider...");
        List<ConsumerEntity> list = this.repository.findAllByName ("%A%");

        Assert.assertNotNull ("There are consumer...", list);
        Assert.assertFalse ("There are consumer...",list.isEmpty ());
    }

    @Test
    public void testGetAllForCity () {

        logger.info ("Getting consumer...");
        List<ConsumerEntity> list = this.repository.findAllByCity (Integer.valueOf (1));

        Assert.assertNotNull ("There are consumers...", list);
        Assert.assertFalse ("There are consumers...",list.isEmpty ());
    }

    @Test
    public void testGetForDNI () {

        logger.info ("Getting consumer...");
        List<ConsumerEntity> list = this.repository.findAllByDNI (Integer.valueOf (10));

        Assert.assertNotNull ("There are consumer...", list);
        Assert.assertFalse ("There are consumer...",list.isEmpty ());
    }




}

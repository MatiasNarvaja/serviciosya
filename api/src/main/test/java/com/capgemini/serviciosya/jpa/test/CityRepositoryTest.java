package com.capgemini.serviciosya.jpa.test;

import com.capgemeini.serviciosya.jpa.entities.jpa.CityEntity;
import com.capgemeini.serviciosya.jpa.entities.jpa.CountryEntity;
import com.capgemeini.serviciosya.jpa.entities.jpa.ProvinceEntity;
import com.capgemeini.serviciosya.jpa.repositories.jpa.ICityRepository;
import com.capgemeini.serviciosya.jpa.repositories.jpa.ICountryRepository;
import com.capgemeini.serviciosya.jpa.repositories.jpa.IProvinceRepository;
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


@RunWith (SpringJUnit4ClassRunner.class)
@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.NONE , classes = JpaConfiguration.class)
@FixMethodOrder (MethodSorters.NAME_ASCENDING)

public class CityRepositoryTest {

    @Autowired
    private ICityRepository   repositoryCity = null;

    @Autowired
    private IProvinceRepository repositoryProvince = null;

    @Autowired
    private ICountryRepository repositoryCountry = null;

    private final Logger logger = LoggerFactory.getLogger (ProvinceRepositoryTest.class);


    public CityRepositoryTest () {

        super ();
    }

    @Before
    public void setup () {

        logger.info ("Creating countries...");
        CountryEntity[] countries = new CountryEntity [] {

                new CountryEntity (Integer.valueOf (1), "ar", "Argentina"),
                new CountryEntity (Integer.valueOf (2), "ve", "Venezuela")
        };
        logger.debug (String.format ("Objects country created %s", Arrays.toString (countries)));

        logger.debug ("Saving countries...");
        this.repositoryCountry.save (Arrays.asList (countries));
        logger.debug (String.format ("Countries saved %s", Arrays.toString (countries)));


        logger.info ("Creating provinces...");
        ProvinceEntity[] provinces = new ProvinceEntity [] {

                new ProvinceEntity (Integer.valueOf (1), "Buenos Aires", countries[0]),
                new ProvinceEntity (Integer.valueOf (2), "Cordoba", countries[0]),
                new ProvinceEntity (Integer.valueOf (3), "Caracas", countries[1]),
                new ProvinceEntity (Integer.valueOf (4), "Miranda", countries[0])
        };
        logger.debug (String.format ("Objects province created %s", Arrays.toString (countries)));

        logger.debug ("Saving provinces...");
        this.repositoryProvince.save (Arrays.asList (provinces));
        logger.debug (String.format ("Provinces saved %s", Arrays.toString (provinces)));



        logger.info ("Creating cities...");
        CityEntity[] cities = new CityEntity [] {


                new CityEntity(Integer.valueOf(1),provinces[0],"Vicente Lopez"),
                new CityEntity(Integer.valueOf(2),provinces[0],"Munro"),
                new CityEntity(Integer.valueOf(3),provinces[0],"villa Martelli"),
                new CityEntity(Integer.valueOf(4),provinces[1],"Villa Caeiro"),


        };
        logger.debug (String.format ("Objects city created %s", Arrays.toString (provinces)));

        logger.debug ("Saving cities...");
        this.repositoryCity.save (Arrays.asList (cities));
        logger.debug (String.format ("cities saved %s", Arrays.toString (cities)));




    }

    @Test
    public void testGetAllByProvince () {

        logger.info ("Getting cities...");

        ProvinceEntity p = new ProvinceEntity ();
        p.setId (Integer.valueOf (3));

        List<CityEntity> list = this.repositoryCity.findAllByProvince(p);

        Assert.assertNotNull ("There are cities...", list);
        Assert.assertFalse ("There are cities...",list.isEmpty ());
    }


}

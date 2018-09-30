package com.capgemini.serviciosya.controller;


import com.capgemeini.serviciosya.beans.entity.CountryEntity;
import com.capgemeini.serviciosya.dao.ICountryDao;
import com.capgemeini.serviciosya.beans.entity.ProvinceEntity;
import com.capgemeini.serviciosya.dao.IProvinceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("provinces")
public class ProvinceController {

    @Autowired
    private IProvinceDao provinceDao;

    @Autowired
    private ICountryDao countryDao;

    public ProvinceController () {

        super ();
    }


    @RequestMapping (method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get () {

        // Return the value.
        return ResponseEntity.ok (this.provinceDao.findAll ());
    }

    @RequestMapping (value = "/{id}", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get (@PathVariable("id") Integer id) {


        ProvinceEntity c = this.provinceDao.findOne (id);

        if (c == null) {

            return ResponseEntity.notFound().build();

        } else {

            return ResponseEntity.ok (c);
        }
    }

    @RequestMapping (value = "/{id}/newName", method = RequestMethod.PUT,consumes={MediaType.APPLICATION_JSON_VALUE}, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> update (@PathVariable("id") Integer id,@PathVariable("newName") String newName) {


        ProvinceEntity p = this.provinceDao.findOne (id);

        if (p == null) {

            return ResponseEntity.notFound().build();

        } else {


            p.setName(newName);
            this.provinceDao.save(p);


            return ResponseEntity.ok (p);
        }
    }

    @RequestMapping (value = "/{newName}/{idCountry}", method = RequestMethod.POST,consumes={MediaType.APPLICATION_JSON_VALUE},produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> create (@PathVariable("newName") String newName,@PathVariable("idCountry") Integer idCountry) {

        CountryEntity c = this.countryDao.findOne(idCountry);

        if (c == null) {

            return ResponseEntity.notFound().build();
            }
        else {
            ProvinceEntity p = new ProvinceEntity();
            p.setName(newName);
            p.setCountry(c);
            p = this.provinceDao.save(p);


            return ResponseEntity.ok(p);

            }

    }

}

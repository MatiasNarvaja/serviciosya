package com.capgemini.serviciosya.controller;

import com.capgemeini.serviciosya.beans.entity.CityEntity;
import com.capgemeini.serviciosya.beans.entity.ProvinceEntity;
import com.capgemeini.serviciosya.dao.ICityDao;
import com.capgemeini.serviciosya.dao.IProvinceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping ("cities")
public class CityController {

    @Autowired
    private ICityDao cityDao;
    @Autowired
    private IProvinceDao provinceDao;

    public CityController(){
        super();
    }

    @RequestMapping (method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get () {

        // Return the value.
        return ResponseEntity.ok (this.cityDao.findAll ());
    }

    @RequestMapping (value = "/{id}", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get (@PathVariable("id") Integer id) {


        CityEntity c = this.cityDao.findOne (id);

        if (c == null) {

            return ResponseEntity.notFound().build();

        } else {

            return ResponseEntity.ok (c);
        }
    }

    @RequestMapping (value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete (@PathVariable("id") Integer id) {
        CityEntity c = this.cityDao.findOne(id);

        if(c == null){
            return ResponseEntity.notFound().build();
        }

        else {

            this.cityDao.delete(id);

            return ResponseEntity.ok(204);

        }

    }
    @RequestMapping (value = "/{id}/{newName}", method = RequestMethod.PUT,consumes={MediaType.APPLICATION_JSON_VALUE}, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> update (@PathVariable("id") Integer id,@PathVariable("newName") String newName) {


        CityEntity c = this.cityDao.findOne (id);

        if (c == null) {

            return ResponseEntity.notFound().build();

        } else {


            c.setName(newName);
            this.cityDao.save(c);


            return ResponseEntity.ok (c);
        }
    }

    @RequestMapping (value = "/{newName}/{idProvince}", method = RequestMethod.POST,consumes={MediaType.APPLICATION_JSON_VALUE},produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> create (@PathVariable("newName") String newName,@PathVariable("idProvince") Integer idProvince) {

        ProvinceEntity p = this.provinceDao.findOne(idProvince);

        if (p == null) {

            return ResponseEntity.notFound().build();
        }
        else {
            CityEntity c = new CityEntity();
            c.setName(newName);
            c.setProvince(p);
            c = this.cityDao.save(c);
            return ResponseEntity.ok(c);

        }

    }





}

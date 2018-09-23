
package com.capgemini.serviciosya.service;


import com.capgemini.serviciosya.dao.IOccupationDao;


public class OccupationService {


    private IOccupationDao occupationDao;


    public OccupationService () {

        super ();
    }

    public OccupationService (IOccupationDao occupationDao) {

        super ();

        this.occupationDao = occupationDao;
    }



}
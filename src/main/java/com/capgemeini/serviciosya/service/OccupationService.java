
package com.capgemeini.serviciosya.service;


import java.util.List;

import com.capgemeini.serviciosya.beans.domain.Occupation;
import com.capgemeini.serviciosya.dao.IOccupationDao;
import sun.plugin.util.PluginConsoleController;


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
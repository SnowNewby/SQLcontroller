package org.example;

import org.example.model.dao.NorthwindDao;
import org.example.model.dao.NorthwindDaoImplNames_update;
import org.example.model.dao.NorthwindDaoImplSalary_raise;


public class Main {

    public static void main(String[] args) {

        NorthwindDao northwindDao = new NorthwindDaoImplSalary_raise();
        NorthwindDao northwindDao1 = new NorthwindDaoImplNames_update();


        northwindDao.updateNames(northwindDao1.getEmployees());

        //northwindDao.updateNames(northwindDao.getEmployees());
    }

}
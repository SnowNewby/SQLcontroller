package org.example;

import org.example.model.dao.NorthwindDao;
import org.example.model.dao.NorthwindDaoImplSalary_raise;


public class Main {

    public static void main(String[] args) {
        NorthwindDao northwindDao = new NorthwindDaoImplSalary_raise();

        //northwindDao.increaseSalary(northwindDao.getEmployees(), northwindDao.getSalary());

        //northwindDao.updateNames(northwindDao.getEmployees());
    }
}
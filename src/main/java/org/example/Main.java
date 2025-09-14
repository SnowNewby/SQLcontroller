package org.example;

import org.example.model.dao.EmployeeEntity;
import org.example.model.dao.NorthwindDao;
import org.example.model.dao.NorthwindDaoImpl;
import org.example.model.dao.SalariesEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {

    public static void main(String[] args) {

        NorthwindDao northwindDao = new NorthwindDaoImpl();
        northwindDao.increaseSalary(northwindDao.getEmployees(), northwindDao.getSalary());

    }
}
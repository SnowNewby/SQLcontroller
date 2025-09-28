package org.example;

import org.example.model.dao.*;
import org.example.sevice.NameService;


public class Main {

    public static void main(String[] args) {


        NorthwindDao northwindDao = new NorthwindDaoImplSalary_raise();  //todo remove this line
        NorthwindDao northwindDao1 = new NorthwindDaoImplNames_update(); //todo remove this line

        EmployeeDao employeeDao = new EmployeeDaoImpl();
        NameService nameService = new NameService();

        //логика для обновления имён
        var employees = employeeDao.getEmployees();
        nameService.processNames(employees); //TODO из метода processNames нужно возвращать листр сотрудников с обновлёнными именами
        employeeDao.updateNames(employees);

        //todo релизовать логику для обновления зарплат ниже

    }

}
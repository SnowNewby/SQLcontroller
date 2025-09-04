package org.example.model.dao;

/*Метод для ArrayList, который не понадобился
так как перешел на HashMap.
 */

import java.math.BigDecimal;

public class Employee {
    private static  Integer id;
    private static String value;
    private static BigDecimal salary;

    public Employee(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    public Employee(Integer id, BigDecimal salary) {
        this.id = id;
        this.salary = salary;
    }

    public static Integer getId() {
        return id;
    }

    public static String getValue(){
        return value;
    }

    public static BigDecimal getSalary() {
        return salary;
    }

    public String toString(){
        return "id" + id + "value" + value;
    }



}

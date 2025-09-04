package org.example;

import java.util.HashMap;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {


        //Метод SQLInput загружает и помещает в соответствующие мапы значения.
        HashMap<Integer, Double> salary = null;
        HashMap<Integer, String> employees = new HashMap<>();

        String getSalary = "SELECT * FROM employees_salary";
        String getEmployees = "SELECT * FROM employees";

        SQLInput sql = new SQLInput();
        salary = sql.getEmployeesSalary(getSalary);
        sql.EmployeeTitleInput(employees, getEmployees);

        //Пробный вывод в консоль
        System.out.println("Должности: " + employees);
        System.out.println("Зарплата:" + salary);

        //Метод SalaryOut обновляет значения в таблице зарплаты
        String updateRequest = "UPDATE employees_salary SET salary = ? WHERE employee_id = ?";
        SalaryOut tablesSalary = new SalaryOut(updateRequest, salary, employees);
        tablesSalary.RequestToTable();


    }
}
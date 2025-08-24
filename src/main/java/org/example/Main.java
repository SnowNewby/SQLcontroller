package org.example;

import java.util.HashMap;


public class Main {

    public static void main(String[] args) {


        //Метод SQLInput загружает и помещает в соответствующие мапы значения.
        String request = "SELECT * FROM employees_salary";
        String request2 = "SELECT * FROM employees";

        HashMap<Integer, Double> salary = new HashMap<>();
        HashMap<Integer, String> employees = new HashMap<>();

        SQLInput sql = new SQLInput(request);
        sql.SalaryInput(salary);
        sql.EmployeeInput(employees);


        //Пробный вывод в консоль
        System.out.println("Должности: " + employees);
        System.out.println("Зарплата:" + salary);

        //Метод SalaryOut обновляет значения в таблице зарплаты
        String update = "UPDATE employees_salary SET salary = ? WHERE employee_id = ?";
        SalaryOut tablesSalary = new SalaryOut(update, salary, employees);
        tablesSalary.RequestToTable();


    }
}
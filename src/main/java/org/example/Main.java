package org.example;

import org.example.model.dao.*;
import org.example.sevice.NameService;
import org.example.sevice.SalaryService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


public class Main {
    EmployeeDao employeeDao = new EmployeeDaoImpl();
    SalaryDao salaryDao = new SalaryDaoImpl();
    NameService nameService = new NameService();
    SalaryService salaryService = new SalaryService();

    public static void main(String[] args) {
        try  {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите что вы хотите сделать?:\n" +
                                        "1. Поменять зарплату\n" +
                                        "2. Изменить ФИО сотрудников");
            String request = reader.readLine();
            Main main = new Main();
            switch (request) {
                case "1" :
                    main.Salaries();
                    break;
                case "2" :
                    main.Names();
                    return;
                default:
                    System.err.println("Введите правильное значение!");
                    break;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void Salaries() {


        var employees = employeeDao.getEmployees(); // Получаю сотрудников
        var salaries = salaryDao.getSalary(); // Получаю зарплату
            System.out.println(salaries);
            salaryService.increaseSalary(employees, salaries); // Индексирую зарплату
            salaryDao.updateSalary(salaries); // Выгружаю данные в БД

    }

    public void Names() {

            var employees = employeeDao.getEmployees(); // Получаю сотрудников
            System.out.println(employees);
            nameService.processNames(employees); // Меняю Фамилию/Имя сотрудника
            employeeDao.updateNames(employees); // Выгружаю данные в БД
    }
}
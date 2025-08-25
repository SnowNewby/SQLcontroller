package org.example;

import java.util.HashMap;


public class Main {

    public static void main(String[] args) {

        //Вопросы:
        //1. При написании тестов создаются обьявленные переменные и проверяется
        // выполняется ли условие метода?

        //2. Есть ли какой-то метод выгрузить все данные из БД в одну, например, мапу с примитивными типами?
        // или проще сделать отдельный класс(сущность) с полями и из этих полей уже брать данные для изменения.

        //3. Правильно ли сделал класс Connection? Я так понимаю авторизацию надо было делать отдельным методом.

        //4. Как лучше оформлять JavaDoc? Писать что он принимает, что делает и что возвращает?

        //5. Стоит ли злоупотреблять и разбивать логику множество классов.

        //6. При вводе в idea PreparedStatement меня иногда создавался автоматически
        // конструктор этого метода, что это?

        //Метод SQLInput загружает и помещает в соответствующие мапы значения.
        HashMap<Integer, Double> salary = new HashMap<>();
        HashMap<Integer, String> employees = new HashMap<>();

        String getSalary = "SELECT * FROM employees_salary";
        String getEmployees = "SELECT * FROM employees";

        SQLInput sql = new SQLInput();
        sql.SalaryInput(salary, getSalary);
        sql.EmployeeTitleInput(employees, getEmployees);


        //Пробный вывод в консоль
        System.out.println("Должности: " + employees);
        System.out.println("Зарплата:" + salary);

        //Метод SalaryOut обновляет значения в таблице зарплаты
        String update = "UPDATE employees_salary SET salary = ? WHERE employee_id = ?";
        SalaryOut tablesSalary = new SalaryOut(update, salary, employees);
        tablesSalary.RequestToTable();


    }
}
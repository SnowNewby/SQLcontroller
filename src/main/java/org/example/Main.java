package org.example;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.sql.*;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) {
        //Устанавливаю соединение-------------------------|
        Connection auth = new Connection("postgres", "1");

        //Загружаю таблицу сотрудников--------------------|
        HashMap<Integer, Double> salary = new HashMap<>();
        try (Statement stmt = auth.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM employees_salary")) {

            while (rs.next()) {
                salary.put(rs.getInt("employee_id"), rs.getDouble("salary"));
            }
            System.out.println("Успешно загружена зарплатная таблица");

        } catch (SQLException e) {
            System.err.println("Ошибка подключения к зарплатной таблице. Ошибка: " + e.getMessage());
        }


        //Загружаю зарплатную таблицу-------------------------|
        HashMap<Integer, String> employees = new HashMap<>();
        try (Statement stmt = auth.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM employees")) {

            while (rs.next()) {
                employees.put(rs.getInt("employee_id"), rs.getString("title"));
            }
            System.out.println("Успешно загружена таблица сотрудников");

        } catch (SQLException e) {
            System.err.println("Ошибка подключения к таблице сотрудников. Ошибка: " + e.getMessage());
        }
        //Пробный вывод*
        System.out.println("Должности: " + employees);
        System.out.println("Зарплата:" + salary);

        //Индексирую зарплату в цикле-----------------------|
        for (int id = 1; id <= employees.size(); id++) {
            if (salary.containsKey(id) && employees.containsKey(id)) {
                String title = employees.get(id);
                if ("Sales Representative".equalsIgnoreCase(title)) {
                    Double value = salary.get(id);
                    value = value + (value * 2 / 100);
                    salary.replace(id, value);
                } else if ("Vice President, Sales".equalsIgnoreCase(title)) {
                    Double value = salary.get(id);
                    value = value + (value * 10 / 100);
                    salary.replace(id, value);
                } else if ("Sales Manager".equalsIgnoreCase(title)) {
                    Double value = salary.get(id);
                    value = value + (value * 5 / 100);
                    salary.replace(id, value);
                } else if ("Inside Sales Coordinator".equalsIgnoreCase(title)) {
                    Double value = salary.get(id);
                    value = value + (value * 5 / 100);
                    salary.replace(id, value);
                }
            }
        }
        System.out.println("Индексация:" + salary);


        //
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String update = "UPDATE employees_salary SET salary = ? WHERE ID = ?";

        PreparedStatement pstmt = auth.prepareStatement(update);
        try {
            pstmt.addBatch(update);
            Double value = salary.get(1);
            pstmt.setDouble(value);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


}
package org.example;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.sql.*;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) {
        Connection auth = new Connection("jdbc:postgresql://localhost:5432/postgres",
                "postgres", "1");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        HashMap<Integer, Double> salary = new HashMap<>();

        try (Statement stmt = auth.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM employees_salary")) {


            while (rs.next()) {
               salary.put(rs.getInt("employee_id"), rs.getDouble("salary"));
            }

        } catch (SQLException e) {
            System.err.println("Ошибка подключения к зарплатной таблице. Ошибка: " + e.getMessage());
        }

        HashMap<Integer, String> employees = new HashMap<>();

        try (Statement stmt = auth.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM employees")) {

            while (rs.next()) {
                employees.put(rs.getInt("employee_id"), rs.getString("title"));
            }
            System.out.println("Должности: " + employees);
            System.out.println("Зарплата:" + salary);

        } catch (SQLException e) {
            System.err.println("Ошибка подключения к таблице сотрудников. Ошибка: " + e.getMessage());
        }

        //Индексирую зарплату на 30% - торговым представителям
            for (int id = 1; id <= employees.size(); id++) {
                if (salary.containsKey(id) && employees.containsKey(id)) {
                    String title = employees.get(id);
                    if ("Sales Representative".equalsIgnoreCase(title)) {
                        Double value = salary.get(id);
                        value = value + (value * 30 / 100);
                        salary.replace(id, value);
                    } else
                    if ("Vice President, Sales".equalsIgnoreCase(title)) {
                        Double value = salary.get(id);
                        value = value + (value * 95 / 100);
                        salary.replace(id, value);
                    } else
                    if ("Sales Manager".equalsIgnoreCase(title)) {
                        Double value = salary.get(id);
                        value = value + (value * 41 / 100);
                        salary.replace(id, value);
                    } else
                    if ("Inside Sales Coordinator".equalsIgnoreCase(title)) {
                        Double value = salary.get(id);
                        value = value + (value * 53.4  / 100);
                        salary.replace(id, value);
                    }
                }
            }


        System.out.println("Индексация:" + salary);
    }
}
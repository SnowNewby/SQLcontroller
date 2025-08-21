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


        HashMap<Integer, Float> salary = new HashMap<>();

        try (Statement stmt = auth.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM employees_salary")) {


            while (rs.next()) {
               salary.put(rs.getInt("employee_id"), rs.getFloat("salary"));
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

        } catch (SQLException e) {
            System.err.println("Ошибка подключения к таблице сотрудников. Ошибка: " + e.getMessage());
        }

        if (salary.equals(employees)) {
            System.out.println(1);
        }
    }
}
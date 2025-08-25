package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class SQLInput {
    Connection auth = new Connection("postgres", "1");

//Реализация запросов к PostgresSQL через Statement
    /**
     * command "SELECT * FROM employees_salary"
     * @param salary get table "employee_id" and "salary"
     * @return HashMap data from SQL table salary
     */
    public HashMap SalaryInput(HashMap<Integer, Double> salary, String request) {
        try (Statement stmt = auth.createStatement();
             ResultSet rs = stmt.executeQuery(request)) {
            while (rs.next()) {
                salary.put(rs.getInt("employee_id"), rs.getDouble("salary"));
            }
            stmt.close(); // Закрываю запрос.
            System.out.println("Успешно загружена зарплатная таблица"); //Проверка корректно ли загрузилась таблица
        } catch (SQLException e) {
            System.err.println("Ошибка подключения к зарплатной таблице. Ошибка: " + e.getMessage());
        }
        return salary;


    }

    /**
     * command "SELECT * FROM employees"
     * @param employees get table "employee_id" and "title"
     * @return HashMap data from SQL table employees
     */
    public HashMap EmployeeTitleInput(HashMap<Integer, String> employees, String request) {
        try (Statement stmt = auth.createStatement();
             ResultSet rs = stmt.executeQuery(request)) {
            while (rs.next()) {
                employees.put(rs.getInt("employee_id"), rs.getString("title"));
            }
            stmt.close(); // Закрываю запрос
            System.out.println("Успешно загружена таблица сотрудников"); //Проверка загрузилась ли корректно таблица
        } catch (SQLException e) {
            System.err.println("Ошибка подключения к таблице сотрудников. Ошибка: " + e.getMessage());
        }
        return employees;
    }

    /**
     * command "SELECT * FROM employees"
     * @param employeesName get table "employee_id" and "first_name"
     * @return HashMap data from SQL table employees
     */
    public HashMap EmployeeName(HashMap<Integer, String> employeesName, String request) {

        try {PreparedStatement pstmt = auth.prepareStatement(request);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {


            }
                pstmt.close();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employeesName;
    }
    }

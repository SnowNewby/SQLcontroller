package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class SQLInput {
    String request;
    Connection auth = new Connection("postgres", "1");
    Statement stmt = auth.createStatement();

    public SQLInput(String request) {
        this.request = request;
    }
    /**
     * @param
     * salary "id" and "salary" employees
     * @return
     * HashMap data from SQL table employee_salary
     */
    public HashMap SalaryInput(HashMap<Integer, Double> salary) {
        {
       try (ResultSet rs = stmt.executeQuery(request)) {
            while (rs.next()) {
                salary.put(rs.getInt("employee_id"), rs.getDouble("salary"));
            }
            System.out.println("Успешно загружена зарплатная таблица"); //Проверка корректно ли загрузилась таблица
        } catch (SQLException e) {
            System.err.println("Ошибка подключения к зарплатной таблице. Ошибка: " + e.getMessage());
        }
            return salary;
        }

    }

    /**
     * @param
     * employees "id" and "title" employees
     * @return
     * HashMap data from SQL table employees
     */
    public HashMap EmployeeInput(HashMap<Integer, String> employees) {
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM employees")) {
                while (rs.next()) {
                    employees.put(rs.getInt("employee_id"), rs.getString("title"));
                }
                System.out.println("Успешно загружена таблица сотрудников"); //Проверка загрузилась ли корректно таблица
            } catch (SQLException e) {
                System.err.println("Ошибка подключения к таблице сотрудников. Ошибка: " + e.getMessage());
            }
            return employees;
    }
}
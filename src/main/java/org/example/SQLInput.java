package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class SQLInput {
    String request;

    public SQLInput(String request) {
        this.request = request;
    }

    public HashMap SalaryInput(HashMap<Integer, Double> salary) {
        {
            Connection auth = new Connection("postgres", "1");
            Statement stmt = auth.createStatement();

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
}
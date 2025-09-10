package org.example.model.dao;

import org.example.ConnectionFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class NorthwindDaoImpl implements NorthwindDao {

    private static final String GET_EMPLOYEE_REQUEST  = "SELECT * FROM employees";
    private static final String GET_SALARY_REQUEST  = "SELECT * FROM employees_salary";
    private static final String UPDATE_SALARY_REQUEST = "UPDATE employees_salary SET salary = ? WHERE employee_id = ?";

    private final ConnectionFactory connection;

    public NorthwindDaoImpl(ConnectionFactory connection) {
        this.connection = new ConnectionFactory("postgres", "1");
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        try(PreparedStatement stmt = connection.prepareStatement(GET_EMPLOYEE_REQUEST);
            ResultSet rs = stmt.executeQuery()){
                while (rs.next()) {
                    employees.add(new Employee(
                            rs.getInt("employee_id"),
                            rs.getString("title")));
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;

    }

    @Override
    public List<Employee> getSalary() {
        List<Employee> salary = new ArrayList<>();
        try(PreparedStatement stmt = connection.prepareStatement(GET_SALARY_REQUEST);
            ResultSet rs = stmt.executeQuery()){
            while (rs.next()) {
                salary.add(new Employee(rs.getInt("employee_id"), rs.getBigDecimal("salary")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return salary;
    }

    @Override
    public int[] increaseSalary(List<Employee> employees) {
        ArrayList<Employee> salary = new ArrayList<>();
        try(PreparedStatement stmt = connection.prepareStatement(UPDATE_SALARY_REQUEST)) {
            //todo лист запросов к бд, которые нужно выполнить в батче
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Индексируем зарплату? \n YES/NO");
            String f = reader.readLine();

            if ("yes".equalsIgnoreCase(f.trim())) {
                for (int id = 1; id <= salary.size(); id++) {
                    Employee value = salary.get(id);

                    stmt.setBigDecimal(1, value);
                    stmt.setInt(2, id);
                    stmt.executeUpdate();
                }
            }

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

        return new int[0];
    }

}

package org.example.model.dao;

import org.example.ConnectionFactory;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NorthwindDaoImpl extends NorthwindDao {

    private static final String GET_EMPLOYEE_REQUEST = "SELECT * FROM employees";
    private static final String GET_SALARY_REQUEST = "SELECT * FROM employees_salary";
    private static final String UPDATE_SALARY_REQUEST = "UPDATE employees_salary SET salary = ? WHERE employee_id = ?";

    private final ConnectionFactory connection;

    public NorthwindDaoImpl() {
        this.connection = new ConnectionFactory("postgres", "1");

    }

    @Override
    public List<EmployeeEntity> getEmployees() {
        List<EmployeeEntity> employees = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(GET_EMPLOYEE_REQUEST);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                employees.add(new EmployeeEntity(rs.getInt("employee_id"),
                        rs.getString("title")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;

    }

    @Override
    public List<SalariesEntity> getSalary() {
        List<SalariesEntity> salary = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(GET_SALARY_REQUEST);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                salary.add(new SalariesEntity(rs.getInt("employee_id"),
                        rs.getBigDecimal("salary")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return salary;
    }

    @Override
    public int[] increaseSalary(List<EmployeeEntity> employees, List<SalariesEntity> salaries) {

        try(PreparedStatement stmt = connection.prepareStatement(UPDATE_SALARY_REQUEST)) {

            /// todo organization add new value salaries in PostgreSQL;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

                return new int[0];
            }

        }

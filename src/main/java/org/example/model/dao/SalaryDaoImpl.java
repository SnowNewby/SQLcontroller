package org.example.model.dao;

import org.example.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaryDaoImpl implements SalaryDao {
    private static final String GET_EMPLOYEE_REQUEST = "SELECT * FROM employees";
    private static final String GET_SALARY_REQUEST = "SELECT * FROM employees_salary";
    private static final String UPDATE_SALARY_REQUEST = "UPDATE employees_salary SET salary = ? WHERE employee_id = ?";

    private final ConnectionFactory connectionFactory;

    public SalaryDaoImpl() {
        this.connectionFactory = new ConnectionFactory("postgres", "1");

    }

    @Override
    public List<SalariesEntity> getSalary() {
        List<SalariesEntity> salary = new ArrayList<>();
        try (PreparedStatement stmt = connectionFactory.prepareStatement(GET_SALARY_REQUEST);
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
    public int[] updateSalary(List<SalariesEntity> salaries) {
        try (PreparedStatement stmt = connectionFactory.prepareStatement(UPDATE_SALARY_REQUEST)) {
            for (int i = 0; i <= salaries.size() - 1; i++) {
                stmt.setBigDecimal(1, salaries.get(i).getValue());
                stmt.setInt(2, salaries.get(i).getId());
                stmt.addBatch();
            }
            return  stmt.executeBatch();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

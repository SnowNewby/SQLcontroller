package org.example.model.dao;

import org.example.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {


    private static final String GET_EMPLOYEE_REQUEST = "SELECT * FROM employees";
    private static final String UPDATE_EMPLOYEE_REQUEST = "UPDATE employees SET last_name = ? WHERE employee_id = ?";

    private final ConnectionFactory connectionFactory;


    public EmployeeDaoImpl() {
        this.connectionFactory = new ConnectionFactory("postgres", "1");
    }

    @Override
    public List<EmployeeEntity> getEmployees() {
        List<EmployeeEntity> employees = new ArrayList<>();

        try (PreparedStatement stmt = connectionFactory.prepareStatement(GET_EMPLOYEE_REQUEST);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                employees.add(new EmployeeEntity(rs.getInt("employee_id"),
                        rs.getString("last_name"),
                        rs.getString("first_name"),
                        rs.getString("title_of_courtesy")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    @Override
    public void updateNames(List<EmployeeEntity> employees) {

        if (employees.isEmpty()) {
            throw new RuntimeException("employee list is empty");
        }

        try (PreparedStatement stmt = connectionFactory.prepareStatement(UPDATE_EMPLOYEE_REQUEST)) {
            for (int i = 0; i <= employees.size() - 1; i++) {
                stmt.setString(1, employees.get(i).getLast_name());
                stmt.setInt(2, employees.get(i).getId());
                stmt.addBatch();
            }
            stmt.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

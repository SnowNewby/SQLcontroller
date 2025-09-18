package org.example.model.dao;

import org.example.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class NorthwindDaoImplNames_update extends NorthwindDao {

    private static final String GET_EMPLOYEE_REQUEST = "SELECT * FROM employees";
    private static final String UPDATE_EMPLOYEE_REQUEST = "UPDATE employees SET last_name = ? WHERE employee_id = ?";

    private final ConnectionFactory CONNECTION;

    public NorthwindDaoImplNames_update() {
        this.CONNECTION = new ConnectionFactory("postgres", "1");

    }

    @Override
    public List<EmployeeEntity> getEmployees() {
        List<EmployeeEntity> employees = new ArrayList<>();
        try (PreparedStatement stmt = CONNECTION.prepareStatement(GET_EMPLOYEE_REQUEST);
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
    public List<SalariesEntity> getSalary() {
        return null;
    }

    @Override
    public void updateNames(List<EmployeeEntity> employees) {

        super.updateNames(employees);

        try (PreparedStatement stmt = CONNECTION.prepareStatement(UPDATE_EMPLOYEE_REQUEST)) {
            for (int i = 0; i <= employees.size() - 1; i++) {
                /// todo найти почему метод не выгружает значение в БД
                stmt.setString(1, employees.get(i).getLast_name());
                stmt.setInt(2, employees.get(i).getId());
                stmt.addBatch();
            }
            stmt.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        /// todo реализация выгрузки в базу измененного значения Фамилии или Имя
    }

}


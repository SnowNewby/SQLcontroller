package org.example.model.dao;

import org.example.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class NorthwindDaoImplNames_update extends NorthwindDao {

    private final String GIVEN_NAMES = "";

    private final ConnectionFactory CONNECTION;

    public NorthwindDaoImplNames_update() {
        this.CONNECTION = new ConnectionFactory("postgres", "1");

    }

    @Override
    public List<EmployeeEntity> getEmployees() {
        List<EmployeeEntity> employees = new ArrayList<>();
        try (PreparedStatement stmt = CONNECTION.prepareStatement(GIVEN_NAMES);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {

                /// todo добавить поля для реализации
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
        return null;
    }

    @Override
    public void updateNames(List<EmployeeEntity> employees) {
        super.updateNames(employees);
        /// todo реализация выгрузки в базу измененного значения Фамилии или Имя
    }

}


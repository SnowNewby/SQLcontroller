package org.example.model.dao;

import java.util.List;

public class SalaryDaoImpl implements SalaryDao {
    @Override
    public List<SalariesEntity> getSalary() {
        return List.of();
    }

    @Override
    public int[] update(List<SalariesEntity> salaries) {
        return new int[0]; // return statement.batchUpdate()
    }
}

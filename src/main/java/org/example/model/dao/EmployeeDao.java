package org.example.model.dao;

import java.util.List;

public interface EmployeeDao {

    /**
     * Метод получает список сотрудников
     */
    List<EmployeeEntity> getEmployees();

    /**
     * Метод меняет фамилию или имя введенное в консоль
     */
     void updateNames(List<EmployeeEntity> employees);

    }

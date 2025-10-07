package org.example.model.dao;

import java.util.List;

public interface SalaryDao {

    /**
     * Метод получает список зарплаты сотрудников
     */
    List<SalariesEntity> getSalary();

    /**
     * Метод индексирует зарплату (необязательно увеличивает, он может и уменьшать - индексировать на 0.8)
     *
     * @return int[updateNumberValue] количество успешных итераций
     */
     int[] updateSalary(List<SalariesEntity> salaries);
}

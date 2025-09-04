package org.example.model.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.example.model.dao.Employee.*;


/// Если реализовывать через ArrayList, то надо значения добавлять в массив
///
/// Либо добавить значения в Хешмап и не менять логику


public interface NorthwindDao {

    /**
     * получить сотрудников
     */
    List<Employee> getEmployees();


    List<Employee> getSalary();

    /**
     * индексировать зарплату
     */
    int[] increaseSalary(List<Employee> employees);

    {
        HashMap<Integer, String> employeesMap = new HashMap<>();
        HashMap<Integer, BigDecimal> salaryMap = new HashMap<>();

        employeesMap.put(getId(), getValue());
        salaryMap.put(getId(), Employee.getSalary());

        for (int id = 1; id <= employeesMap.size(); id++) {
            if (salaryMap.containsKey(id) && employeesMap.containsKey(id)) {
                String title = employeesMap.get(id);
                if ("Sales Representative".equalsIgnoreCase(title)) {
                    BigDecimal value = salaryMap.get(id);
                    value = value + (value * 2 / 100);
                    salaryMap.replace(id, value);
                } else if ("Vice President, Sales".equalsIgnoreCase(title)) {
                    Double value = salaryMap.get(id);
                    value = value.add;
                    salaryMap.replace(id, value);
                } else if ("Sales Manager".equalsIgnoreCase(title)) {
                    BigDecimal value = salaryMap.get(id);
                    value = value + ((value * 5) / 100);
                    salaryMap.replace(id, value);
                } else if ("Inside Sales Coordinator".equalsIgnoreCase(title)) {
                    Double value = salaryMap.get(id);
                    value = value + (value * 5 / 100);
                    salaryMap.replace(id, value);
                }
            }
        }
    }
}


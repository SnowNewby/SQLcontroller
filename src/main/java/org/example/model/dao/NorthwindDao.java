package org.example.model.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/// Если реализовывать через ArrayList, то надо значения добавлять в массив
///
/// Либо добавить значения в Хешмап и не менять логику


public abstract class NorthwindDao {

    /**
     * Получить сотрудников
     */
    public abstract List<EmployeeEntity> getEmployees();

    /**
     * Получить зарплату
     */
    public abstract List<SalariesEntity> getSalary();

    /**
     * Индексировать зарплату
     */
    public int[] increaseSalary(List<EmployeeEntity> employees, List<SalariesEntity> salaries) {

        int updateNumberValue = 0;

        employees = new ArrayList<>(getEmployees());
        salaries = new ArrayList<>(getSalary());

        // Создаю Мап для зарплаты
        Map<Integer, BigDecimal> salaryMap = new HashMap<>();
        for (SalariesEntity salary : salaries) {
            salaryMap.put(salary.getId(), salary.getValue());

        }
        // Создаю Мап для сотрудников
        Map<Integer, String> employeesMap = new HashMap<>();
        for (EmployeeEntity employee : employees) {
            employeesMap.put(employee.getId(), employee.getTitle());
        }

        for (int id = 1; id <= employeesMap.size(); id++) {

            String title = employeesMap.get(id);

            if (employeesMap.containsKey(0) || salaryMap.containsKey(0)) {
                System.err.println("Айди сотрудника не найден!");
                break;

            } else if (employeesMap.containsValue(null)) {
                System.err.println("Графа должность - пустая!");
                break;

            } else if (employeesMap.containsKey(id) == salaryMap.containsKey(id)) {
                if ("Sales Representative".equalsIgnoreCase(title)) {
                    BigDecimal value = salaryMap.get(id);
                    value.multiply(BigDecimal.valueOf(2));
                    salaryMap.put(id, value);
                    updateNumberValue++;
                } else if ("Vice President, Sales".equalsIgnoreCase(title)) {
                    BigDecimal value = salaryMap.get(id);
                    value.multiply(BigDecimal.valueOf(10));
                    salaryMap.put(id, value);
                    updateNumberValue++;
                } else if ("Sales Manager".equalsIgnoreCase(title)) {
                    BigDecimal value = salaryMap.get(id);
                    value.multiply(BigDecimal.valueOf(5));
                    salaryMap.put(id, value);
                    updateNumberValue++;
                } else if ("Inside Sales Coordinator".equalsIgnoreCase(title)) {
                    BigDecimal value = salaryMap.get(id);
                    value.multiply(BigDecimal.valueOf(5));
                    salaryMap.put(id, value);
                    updateNumberValue++;
                }
            }
        }
        System.out.println(employeesMap);
        System.out.println(salaryMap);

        return new int[] {updateNumberValue};
    }
}
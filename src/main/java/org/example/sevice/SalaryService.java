package org.example.sevice;

import org.example.model.dao.EmployeeEntity;
import org.example.model.dao.SalariesEntity;

import java.math.BigDecimal;
import java.util.List;

public class SalaryService {

    public int[] increaseSalary(List<EmployeeEntity> employees, List<SalariesEntity> salaries) {

        int updateNumberValue = 0; // Счётчик успешных итераций

        for (int i = 0; i <= employees.size() - 1; i++) {
            String title = employees.get(i).getTitle();
            Integer idEmployee = employees.get(i).getId();
            Integer idSalary = salaries.get(i).getId();

            // Проверка на нулевые значения и спецсимволы в строке ID.
            if (idEmployee <= 0 || idSalary <= 0 || idSalary.equals('!')) { /// todo прописать спецсимволы в проверку!
                System.err.println("Айди сотрудника не найден!");
                break;

                // Проверка на то что строка должность не пустая.
            } else if (title == null) {
                System.err.println("Графа должность - пустая!");
                break;

                // Цикл обработки заработной платы.
            } else if (idEmployee == idSalary) {
                if ("Sales Representative".equalsIgnoreCase(title)) {
                    BigDecimal salary = salaries.get(i).getValue();
                    BigDecimal percent = salary.multiply(BigDecimal.valueOf(0.05));
                    salary = salary.add(percent);
                    salaries.set(idSalary - 1, new SalariesEntity(idSalary, salary));
                    updateNumberValue++;
                } else if ("Vice President, Sales".equalsIgnoreCase(title)) {
                    BigDecimal salary = salaries.get(i).getValue();
                    BigDecimal percent = salary.multiply(BigDecimal.valueOf(0.15));
                    salary = salary.add(percent);
                    salaries.set(idSalary - 1, new SalariesEntity(idSalary, salary));
                    updateNumberValue++;
                } else if ("Sales Manager".equalsIgnoreCase(title)) {
                    BigDecimal salary = salaries.get(i).getValue();
                    BigDecimal percent = salary.multiply(BigDecimal.valueOf(0.07));
                    salary = salary.add(percent);
                    salaries.set(idSalary - 1, new SalariesEntity(idSalary, salary));
                    updateNumberValue++;
                } else if ("Inside Sales Coordinator".equalsIgnoreCase(title)) {
                    BigDecimal salary = salaries.get(i).getValue();
                    BigDecimal percent = salary.multiply(BigDecimal.valueOf(0.08));
                    salary = salary.add(percent);
                    salaries.set(idSalary - 1, new SalariesEntity(idSalary, salary));
                    updateNumberValue++;
                }
            }
        }
        // Возвращаю массив успешных итераций.
        return new int[] {updateNumberValue};
    }


}

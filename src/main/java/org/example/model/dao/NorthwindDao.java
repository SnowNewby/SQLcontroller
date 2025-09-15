package org.example.model.dao;

import java.math.BigDecimal;
import java.util.List;

public abstract class NorthwindDao {

    /**
     * Метод получает список сотрудников
     */
    public abstract List<EmployeeEntity> getEmployees();

    /**
     * Метод получает список зарплаты сотрудников
     */
    public abstract List<SalariesEntity> getSalary();

    /**
     * Метод индексирует зарплату
     *
     * @return int[updateNumberValue] количество успешных итераций
     */
    public int[] increaseSalary(List<EmployeeEntity> employees, List<SalariesEntity> salaries) {

        int updateNumberValue = 0; // Счётчик успешных итераций

        for (int i = 0; i <= employees.size() - 1; i++) {
            String title = employees.get(i).getTitle();
            Integer idEmployee = employees.get(1).getId();
            Integer idSalary = salaries.get(1).getId();

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
                    salary = salary.multiply(BigDecimal.valueOf(2));
                    salaries.set(idSalary - 1, new SalariesEntity(idSalary, salary));
                    updateNumberValue++;
                } else if ("Vice President, Sales".equalsIgnoreCase(title)) {
                    BigDecimal salary = salaries.get(i).getValue();
                    salary = salary.multiply(BigDecimal.valueOf(2));
                    salaries.set(idSalary - 1, new SalariesEntity(idSalary, salary));
                    updateNumberValue++;
                } else if ("Sales Manager".equalsIgnoreCase(title)) {
                    BigDecimal salary = salaries.get(i).getValue();
                    salary = salary.multiply(BigDecimal.valueOf(2));
                    salaries.set(idSalary - 1, new SalariesEntity(idSalary, salary));
                    updateNumberValue++;
                } else if ("Inside Sales Coordinator".equalsIgnoreCase(title)) {
                    BigDecimal salary = salaries.get(i).getValue();
                    salary = salary.multiply(BigDecimal.valueOf(2));
                    salaries.set(idSalary - 1, new SalariesEntity(idSalary, salary));
                    updateNumberValue++;
                }
            }
        }
        // Возвращаю массив успешных итераций.
        return new int[]{updateNumberValue};
    }


    /**
     * Метод меняет фамилию или имя введенное в консоль
     */
    public void updateNames(List<EmployeeEntity> employees) {
        /// todo реализовать логику смены значения в ArrayList.
    }
}




package org.example.model.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        return new int[]{updateNumberValue};
    }


    /**
     * Метод меняет фамилию или имя введенное в консоль
     */
    public void updateNames(List<EmployeeEntity> employees) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {

            System.out.println("Вы хотите поменять ФИО сотрудника? \n ДА/НЕТ");
            String answer = reader.readLine();

            if (answer.equalsIgnoreCase("ДА")) {
                System.out.println(employees);

                System.out.println("Какой пол? \n **Ms/Mr**");
                String answerTitleCourtesy = reader.readLine();
                if (answerTitleCourtesy == null || answerTitleCourtesy.isEmpty()) {
                    System.err.println("Вы ввели пустую строку!");
                    return;
                }

                System.out.println("Какое имя у сотрудника?");
                String answerFirstName = reader.readLine();
                if (answerFirstName == null || answerFirstName.isEmpty()) {
                    System.err.println("Вы ввели пустую строку!");
                    return;
                }

                System.out.println("Какая фамилия у сотрудника?");
                String answerLastName = reader.readLine();
                if (answerLastName == null || answerLastName.isEmpty()) {
                    System.err.println("Вы ввели пустую строку!");
                    return;
                }

                for (int i = 0; i <= employees.size() - 1; i++) {
                    Integer idEmployee = employees.get(i).getId();
                    String firstName = employees.get(i).getFirst_name();
                    String lastName = employees.get(i).getLast_name();
                    String titleCourtesy = employees.get(i).getTitle_of_courtesy();

                    if (firstName == null || lastName == null || titleCourtesy == null) {
                        System.err.println("Вы не ввели в поиске значение!");
                        return;
                    } else if (firstName == null || lastName == null || titleCourtesy == null) {
                            System.err.println("Проверьте наличие ФИО и пола в таблице!");
                            return;
                        } else if (answerTitleCourtesy.equalsIgnoreCase("Ms")) {
                            if (answerFirstName.equalsIgnoreCase(firstName) && answerLastName.equalsIgnoreCase(lastName)) {
                                System.out.println("Введите новую фамилию.");
                                String newLastName = reader.readLine();
                                employees.set(idEmployee - 1, new EmployeeEntity(idEmployee, newLastName,
                                        answerFirstName, answerTitleCourtesy));
                                System.out.println(employees);
                            }
                        } else if (answerTitleCourtesy.equalsIgnoreCase("Mr")) {
                            /// todo реализация для мужчин
                        }
                    }
                } else {
                System.err.println("Вы отменили операцию по смене ФИО сотрудника!");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        }
    }





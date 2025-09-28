package org.example.sevice;

import org.example.model.dao.EmployeeEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class NameService {

    /**
     * Метод меняет фамилию или имя введенное в консоль
     */
    public void processNames(List<EmployeeEntity> employees) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

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

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

        try  {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            UserInputService userInputService = new UserInputService();
            String[] request = userInputService.Name(); //first/lastName = [0]
                                                        //firstName = [1]
                                                        //lastName = [2]


            for (int i = 0; i <= employees.size() - 1; i++) {
                Integer idEmployee = employees.get(i).getId();
                String firstName = employees.get(i).getFirst_name();
                String lastName = employees.get(i).getLast_name();
                String titleCourtesy = employees.get(i).getTitle_of_courtesy();


                if (firstName == null || lastName == null || titleCourtesy == null) {
                    System.err.println("Проверьте наличие ФИО и пола в таблице!");
                    break;
                } else if (request[0].equalsIgnoreCase("last name")) {
                    if (request[1].equalsIgnoreCase(firstName) && request[2].equalsIgnoreCase(lastName)) {
                        System.out.println("Введите новую фамилию:");
                        String newLastName = reader.readLine();
                        employees.set(idEmployee - 1, new EmployeeEntity(idEmployee, newLastName,
                                firstName));
                        System.out.println(employees);
                    }
                } else if (request[0].equalsIgnoreCase("first name")) {
                    if (request[1].equalsIgnoreCase(firstName) && request[2].equalsIgnoreCase(lastName)) {
                        System.out.println("Введите новое имя:");
                        String newFirstName = reader.readLine();
                        employees.set(idEmployee - 1, new EmployeeEntity(idEmployee, lastName,
                                newFirstName));
                        System.out.println(employees);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
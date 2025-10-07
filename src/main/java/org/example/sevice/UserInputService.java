package org.example.sevice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputService {

    public String[] Name() {
        String request;
        String requestLastName = null;
        String requestFirstName = null;
        String requestFirstOrLastName = null;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Вы хотите поменять ФИО сотрудника? \n YES/NO");
            request = reader.readLine();

            if (request.equalsIgnoreCase("Yes")) {

                System.out.println("Введите что хотите поменять: \n *First Name\\Last Name");
                requestFirstOrLastName = reader.readLine();
                System.out.println("Вы ввели:\n   Изменяем:" + requestFirstOrLastName);
                if (requestFirstOrLastName == null || requestFirstOrLastName.isEmpty()) {
                    System.err.println("Вы ввели пустую строку или неправильные символы!");
                }

                System.out.println("Введите имя сотрудника:");
                requestFirstName = reader.readLine();
                System.out.println("Вы ввели:\n   Пол: " + requestFirstOrLastName +
                        "\n   Имя: " + requestFirstName);
                if (requestFirstName == null || requestFirstName.isEmpty() ||
                        requestFirstName.matches(".*[\\W_]+.*")) {
                    System.err.println("Вы ввели пустую строку или неправильные символы!");
                }

                System.out.println("Введите фамилию сотрудника");
                requestLastName = reader.readLine();
                System.out.println("Вы ввели:\n   Пол: " + requestFirstOrLastName +
                        "\n   Имя: " + requestFirstName +
                        "\n   Фамилия: " + requestLastName);
                if (requestLastName == null || requestLastName.isEmpty() ||
                        requestLastName.matches(".*[\\W_]+.*")) {
                    System.err.println("Вы ввели пустую строку или неправильные символы!");
                } else if (request.equalsIgnoreCase("No")) {
                    System.out.println("Вы отменили операцию по смене ФИО сотрудника!");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new String[]{requestFirstOrLastName, requestFirstName, requestLastName};
    }
}

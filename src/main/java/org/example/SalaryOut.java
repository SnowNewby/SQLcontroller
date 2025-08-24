package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

public class SalaryOut {
    String request;
    HashMap<Integer, Double> salary;
    HashMap<Integer, String> employees;

    public SalaryOut(String request, HashMap<Integer, Double> salary, HashMap<Integer, String> employees) {
        this.request = request;
        this.salary = salary;
        this.employees = employees;
    }


    public String RequestToTable() {

        //Индексирую зарплату по должностям-----------------------|
        for (int id = 1; id <= employees.size(); id++) {
            if (salary.containsKey(id) && employees.containsKey(id)) {
                String title = employees.get(id);
                if ("Sales Representative".equalsIgnoreCase(title)) {
                    Double value = salary.get(id);
                    value = value + (value * 2 / 100);
                    salary.replace(id, value);
                } else if ("Vice President, Sales".equalsIgnoreCase(title)) {
                    Double value = salary.get(id);
                    value = value + (value * 10 / 100);
                    salary.replace(id, value);
                } else if ("Sales Manager".equalsIgnoreCase(title)) {
                    Double value = salary.get(id);
                    value = value + (value * 5 / 100);
                    salary.replace(id, value);
                } else if ("Inside Sales Coordinator".equalsIgnoreCase(title)) {
                    Double value = salary.get(id);
                    value = value + (value * 5 / 100);
                    salary.replace(id, value);
                }
            }
        }
        //Проверка после индексации
        System.out.println("Индексация:" + salary);

        Connection auth = new Connection("postgres", "1");
        PreparedStatement pstmt = auth.prepareStatement(request);

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Индексируем зарплату? \n YES/NO");
            String f = reader.readLine();

            if ("yes".equalsIgnoreCase(f.trim())) {
                for (int id = 1; id <= salary.size(); id++) {
                    Double value = salary.get(id);

                    pstmt.setDouble(1, value);
                    pstmt.setInt(2, id);
                    pstmt.executeUpdate();
                }
                reader.close();
                pstmt.close();
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

        return "Индексация проведена успешно! Поздравляем!";
    }
}




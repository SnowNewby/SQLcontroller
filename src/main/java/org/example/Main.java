package org.example;

import java.sql.*;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) {

        //Загружаю зарплатную таблицу--------------------|
        HashMap<Integer, Double> salary = new HashMap<>();
        SQLInput sqlInput = new SQLInput("SELECT * FROM employees_salary");
        sqlInput.SalaryInput(salary);


       /* try (ResultSet rs = stmt.executeQuery("SELECT * FROM employees_salary")) {

            while (rs.next()) {
                salary.put(rs.getInt("employee_id"), rs.getDouble("salary"));
            }
            System.out.println("Успешно загружена зарплатная таблица"); //Проверка корректно ли загрузилась таблица

        } catch (SQLException e) {
            System.err.println("Ошибка подключения к зарплатной таблице. Ошибка: " + e.getMessage());
        }

        */


        //Загружаю таблицу сотрудников-------------------------|
        Connection auth = new Connection("postgres", "1");
        Statement stmt = auth.createStatement();
        HashMap<Integer, String> employees = new HashMap<>();
        try (ResultSet rs = stmt.executeQuery("SELECT * FROM employees")) {

            while (rs.next()) {
                employees.put(rs.getInt("employee_id"), rs.getString("title"));
            }
            System.out.println("Успешно загружена таблица сотрудников"); //Проверка загрузилась ли корректно таблица

        } catch (SQLException e) {
            System.err.println("Ошибка подключения к таблице сотрудников. Ошибка: " + e.getMessage());
        }

        //Пробный вывод*
        System.out.println("Должности: " + employees);
        System.out.println("Зарплата:" + salary);

        String update = "UPDATE employees_salary SET salary = ? WHERE employee_id = ?";
        SalaryOut tablesSalary = new SalaryOut(update, salary, employees);
        tablesSalary.RequestToTable();





        /*
        Вношу изменения в БД, блок с BufferedReader нужен для защиты от
        постоянных увеличений заработной платы на время теста.
         */



       /* try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Индексируем зарплату? \n YES/NO");
            String request = reader.readLine();

            if (request.equalsIgnoreCase("YES")) {
                for (int id = 1; id <= salary.size(); id++) {
                    Double value = salary.get(id);

                    pstmt.setDouble(1, value);
                    pstmt.setInt(2, id);
                    pstmt.executeUpdate();
                }
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

        */

            //auth.prepareStatement("SELECT * FROM employees_salary");




    }
}
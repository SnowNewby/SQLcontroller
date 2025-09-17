package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;



public class ConnectionFactory {
    private final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String USER;
    private final String PASSWORD;

    public ConnectionFactory(String USER, String PASSWORD) {
        this.USER = USER;
        this.PASSWORD = PASSWORD;
    }

    public Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка подключения" + e.getMessage());
        }
    }

    public Statement createStatement() {
        try {
            return getConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка запроса" + e.getMessage());
        }
    }

    public PreparedStatement prepareStatement(String request) {
        try {
            return getConnection().prepareStatement(request);
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка запроса" + e.getMessage());
        }
    }
}

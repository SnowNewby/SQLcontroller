package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionFactory {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user;
    private final String password;

    public ConnectionFactory(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(url, user, password);
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

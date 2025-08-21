package org.example;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class Connection {
    private final String url;
    private final String user;
    private final String password;

    public Connection(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public java.sql.Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public Statement createStatement() throws SQLException {
        return getConnection().createStatement();
    }

    public PreparedStatement createPreparedStatement() throws SQLException {
        String s = "" ;
        return getConnection().prepareStatement(s);
    }


}

package org.example;

import java.sql.*;

// DatabaseHandler class
class DatabaseHandler {

    private static final String URL = "jdbc:postgresql://localhost:5432/bookstore";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";

    public Connection connect() throws SQLException {
        try {
            System.out.println("Connection to PostgreSQL database established!");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Error establishing connection: " + e.getMessage());
            throw e;
        }
    }

//    public void close() throws SQLException {
//        if (connection != null) {
//            connection.close();
//        }
//    }
}
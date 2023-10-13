package com.example.veb_d7.repositories;

import java.sql.*;
import java.util.Optional;

public class MySqlAbstractRepository {

    public MySqlAbstractRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected Connection newConnection() throws SQLException {
        return DriverManager.getConnection(this.getURL(), this.getUsername(), this.getPassword());
    }

    protected String getURL() {
        return "jdbc:mysql://" + this.getHost() + ":" + this.getPort() + "/" + this.getDatabaseName();
    }
    protected String getHost() {
        return "localhost";
    }

    protected int getPort() {
        return 3306;
    }

    protected String getDatabaseName() {
        return "test_schema";
    }

    protected String getUsername() {
        return "root";
    }

    protected String getPassword() {
        return "123123";
    }

    protected void closeStatement(Statement statement) {
        try {
            Optional.of(statement).get().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void closeResultSet(ResultSet resultSet) {
        try {
            Optional.of(resultSet).get().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void closeConnection(Connection connection) {
        try {
            Optional.of(connection).get().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
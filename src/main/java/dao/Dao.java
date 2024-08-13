package dao;

import java.sql.*;

public abstract class Dao {
    final Connection connection;

    public Dao(Connection connection) {
        this.connection = connection;
    }

    void executeStatement(String command) {
        try {
            Statement statement = this.connection.createStatement();
            statement.execute(command);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    ResultSet executeQuery(String command) {
        try {
            Statement statement = this.connection.createStatement();
            return statement.executeQuery(command);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}

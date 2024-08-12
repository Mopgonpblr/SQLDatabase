package dao;

import enums.TicketType;

import java.sql.*;
import java.time.LocalDate;

public class DAO {

    private final Connection connection;

    public DAO(Connection connection) {
        this.connection = connection;
    }

    private void executeStatement(String command) {
        try {
            Statement statement = this.connection.createStatement();
            statement.execute(command);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private ResultSet executeQuery(String command) {
        try {
            Statement statement = this.connection.createStatement();
            return statement.executeQuery(command);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public void saveTickets(int id, int userId, TicketType ticketType) {
        executeStatement("INSERT INTO tickets VALUES ("
                + id + ","
                + userId + ",'"
                + ticketType.name() + "', '"
                + LocalDate.now() + "');");

    }

    public void saveUsers(int id, String name) {
        executeStatement("INSERT INTO users VALUES ("
                + id + ",'"
                + name + "','"
                + LocalDate.now() + "');");
    }

    public void fetchTickets(int id, int userId) throws SQLException {

        ResultSet resultSet = executeQuery("SELECT * from tickets " +
                "WHERE id = " + id + " AND user_id =" + userId + ";");

        System.out.println("ID| User ID | Ticket Type | Creation Date");
        System.out.println("------------------------------------------------");
        while (resultSet != null && resultSet.next()) {
            String columnValue = resultSet.getString("id") +
                    " | " + resultSet.getString("user_id") +
                    " | " + resultSet.getString("ticket_type") +
                    " | " + resultSet.getString("creation_date");
            System.out.println(columnValue);
            System.out.println("------------------------------------------------");
        }
    }

    public void fetchUsers(int id) throws SQLException {
        ResultSet resultSet = executeQuery("SELECT * from users WHERE id = " + id + ";");

        System.out.println("ID| Name | Creation Date");
        System.out.println("------------------------------------------------");
        while (resultSet != null && resultSet.next()) {
            String columnValue = resultSet.getString("id") +
                    " | " + resultSet.getString("name") +
                    " | " + resultSet.getString("creation_date");
            System.out.println(columnValue);
            System.out.println("------------------------------------------------");
        }
    }

    public void updateTicketType(int id, TicketType ticketType) {
        executeStatement("UPDATE tickets " +
                "SET ticket_type ='" + ticketType.name()
                + "' WHERE id = " + id + ";");
    }

    public void deleteUsers(int id) {
        executeStatement("DELETE FROM tickets " +
                "WHERE EXISTS (SELECT * FROM tickets " +
                "WHERE user_id = " + id + ");");
        executeStatement("DELETE FROM users " +
                "WHERE EXISTS (SELECT * FROM users " +
                "WHERE id = " + id + ");");
    }

    public void deleteTickets(int id) {
        executeStatement("DELETE FROM tickets " +
                "WHERE EXISTS (SELECT * FROM tickets " +
                "WHERE id = " + id + ");");
    }
}
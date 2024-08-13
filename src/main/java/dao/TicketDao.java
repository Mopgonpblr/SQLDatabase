package dao;

import data.SqlQueries;
import enums.TicketType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class TicketDao extends Dao{

    public TicketDao(Connection connection) {
        super(connection);
    }

    public void saveTickets(int id, int userId, TicketType ticketType) {
        executeStatement(String.format(SqlQueries.SAVETICKETS, id, userId, ticketType.name(), LocalDate.now()));
    }

    public void fetchTickets(int id, int userId) throws SQLException {

        ResultSet resultSet = executeQuery(String.format(SqlQueries.FETCHTICKETS, id, userId));

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

    public void updateTicketType(int id, TicketType ticketType) {
        executeStatement(String.format(SqlQueries.UPDATETICKETTYPE, ticketType.name(), id));
    }

    public void deleteTickets(int id) {
        executeStatement(String.format(SqlQueries.DELETETICKETS,id));
    }
}

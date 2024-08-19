package dao;

import data.SqlQueries;
import enums.TicketType;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Component
public class TicketDao {

    private final DataSource dataSource;

    public TicketDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void saveTickets(int id, int userId, TicketType ticketType) throws SQLException {
        try (PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(SqlQueries.SAVE_TICKETS)
        ) {
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, userId);
            preparedStatement.setString(3, ticketType.name());
            preparedStatement.setDate(4, Date.valueOf(LocalDate.now()));
            preparedStatement.execute();
        }
    }

    public void fetchTicketsById(int id) throws SQLException {
        try (PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(SqlQueries.FETCH_TICKETS_BY_ID)
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
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
    }

    public void fetchTicketsByUserId(int userId) throws SQLException {
        try (PreparedStatement preparedStatement
                     = dataSource.getConnection().prepareStatement(SqlQueries.FETCH_TICKETS_BY_USER_ID)
        ) {
            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

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
    }

    public void updateTicketType(int id, TicketType ticketType) throws SQLException {
        try (PreparedStatement preparedStatement
                     = dataSource.getConnection().prepareStatement(SqlQueries.UPDATE_TICKET_TYPE)
        ) {
            preparedStatement.setString(1, ticketType.name());
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
        }
    }

    public void deleteTickets(int id) throws SQLException {
        try (PreparedStatement preparedStatement
                     = dataSource.getConnection().prepareStatement(SqlQueries.DELETE_TICKETS)
        ) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        }
    }
}

import dao.TicketDao;
import dao.UserDao;
import enums.TicketType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Postgresqldb {
    public static void main(String[] args) throws SQLException {

        String jdbcUrl = "jdbc:postgresql://localhost:5432/my_ticket_service_db";
        String username = "username";
        String password = "password";

        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        UserDao userDao = new UserDao(connection);
        TicketDao ticketDao = new TicketDao(connection);

        //Save a new user
        userDao.saveUsers(1, "USER1");

        //fetch all users with id equal 1
        System.out.println("=============USERS=============");
        userDao.fetchUsers(1);

        //Save a new ticket
        ticketDao.saveTickets(1, 1, TicketType.DAY);

        //fetch all tickets with id equal 1 and user_id equal 1
        System.out.println("=============TICKETS=============");
        ticketDao.fetchTickets(1, 1);

        //update the ticket type of the ticket with id equal 1 to the WEEK type
        ticketDao.updateTicketType(1, TicketType.WEEK);
        ticketDao.fetchTickets(1, 1);

        //delete all tickets with id equal 1
        ticketDao.deleteTickets(1);

        //delete all users with id equal 1
        userDao.deleteUsers(1);

        connection.close();
    }
}
import dao.ContextConfiguration;
import dao.TicketDao;
import dao.UserDao;
import enums.TicketType;

import java.sql.SQLException;

public class Postgresqldb {
    public static void main(String[] args) throws SQLException {

        UserDao userDao = new UserDao(ContextConfiguration.dataSource());
        TicketDao ticketDao = new TicketDao(ContextConfiguration.dataSource());

        //Save a new user
        userDao.saveUsers(1, "USER1");

        //fetch all users with id equal 1
        System.out.println("=============USERS=============");
        userDao.fetchUsers(1);

        //Save a new ticket
        ticketDao.saveTickets(1, 1, TicketType.DAY);

        //fetch all tickets with id equal 1
        System.out.println("=============TICKETS=============");
        ticketDao.fetchTicketsById(1);

        //fetch all tickets with user_id equal 1
        System.out.println("=============TICKETS=============");
        ticketDao.fetchTicketsByUserId(1);

        //update the ticket type of the ticket with id equal 1 to the WEEK type
        ticketDao.updateTicketType(1, TicketType.WEEK);
        ticketDao.fetchTicketsById(1);

        //delete all tickets with id equal 1
        ticketDao.deleteTickets(1);

        //delete all users with id equal 1
        userDao.deleteUsers(1);

    }
}
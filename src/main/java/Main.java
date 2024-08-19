import dao.ContextConfiguration;
import dao.TicketDao;
import dao.UserDao;
import enums.TicketType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws SQLException {

        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        UserDao userDao = context.getBean("userDao", UserDao.class);
        TicketDao ticketDao = context.getBean("ticketDao", TicketDao.class);

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
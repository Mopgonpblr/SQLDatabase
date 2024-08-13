import entities.Ticket;
import entities.User;
import enums.TicketType;
import service.TicketService;
import service.UserService;

import java.util.List;

public class Postgresqldb {
    public static void main(String[] args) {


        User user = new User(1, "USER1");
        Ticket ticket1 = new Ticket(1,1,TicketType.DAY);
        Ticket ticket2 = new Ticket(2,1,TicketType.YEAR);

        UserService userService = new UserService();
        TicketService ticketService = new TicketService();

        //Create a new user
        userService.createUser(user);

        //get the user with id equal 1
        System.out.println(userService.findUser(1));

        //Create new tickets
        ticketService.createTicket(ticket1);
        ticketService.createTicket(ticket2);


        //fetch all tickets with user_id equal 1
        System.out.println("=============TICKETS=============");
        List<Ticket> tickets = ticketService.findTicketByUserId(1);
        for(Ticket ticket: tickets){
            System.out.println(ticket);
        }

        //update the ticket type of the ticket with id equal 1 to the WEEK type
        ticketService.updateTicket(1, TicketType.WEEK);

        //fetch the ticket with id equal 1
        System.out.println(ticketService.findTicketById(1));

        userService.updateUser(1,"John",TicketType.MONTH);
        System.out.println(userService.findUser(1));
        tickets = ticketService.findTicketByUserId(1);
        for(Ticket ticket: tickets){
            System.out.println(ticket);
        }

        //delete all tickets with id equal 1
        ticketService.deleteTicket(ticket1);

        //delete all users with id equal 1
        userService.deleteUser(user);
    }
}
package service;

import dao.TicketDao;
import entities.Ticket;
import enums.TicketType;

import java.util.List;

public class TicketService {
    private TicketDao ticketDao = new TicketDao();

    public Ticket findTicketById(int userId){
        return ticketDao.fetchTicketsById(userId);
    }

    public List<Ticket> findTicketByUserId(int userId){
        return ticketDao.fetchTicketsByUserId(userId);
    }

    public void createTicket(Ticket ticket){
        ticketDao.save(ticket);
    }

    public void updateTicket(int id, TicketType ticketType){
        ticketDao.updateTicketType(id,ticketType);
    }

    public void deleteTicket(Ticket ticket){
        ticketDao.delete(ticket);
    }
}

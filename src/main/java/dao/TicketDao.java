package dao;

import entities.Ticket;
import entities.User;
import enums.TicketType;
import hibernate.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class TicketDao{

    public void save(Ticket ticket) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(ticket);
        transaction.commit();
        session.close();
    }

    public Ticket fetchTicketsById(int id) {
        return SessionFactoryProvider.getSessionFactory().openSession().get(Ticket.class, id);
    }

    public List<Ticket> fetchTicketsByUserId(int userId) {
        return SessionFactoryProvider.getSessionFactory().openSession().createQuery("from Ticket WHERE userId = :id", Ticket.class).setParameter("id",userId).list();
    }

    public void updateTicketType(int id, TicketType ticketType) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Ticket ticket = session.get(Ticket.class,id);
        ticket.setTicketType(ticketType);
        session.saveOrUpdate(ticket);
        transaction.commit();
        session.close();
    }

    public void delete(Ticket ticket) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(ticket);
        transaction.commit();
        session.close();
    }
}
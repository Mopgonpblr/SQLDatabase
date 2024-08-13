package dao;

import entities.User;
import enums.TicketType;
import hibernate.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class UserDao {

    public void save(User user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public User fetchUser(int id) {
        return SessionFactoryProvider.getSessionFactory().openSession().get(User.class, id);
    }

    public void updateUserAndTicket(int id, String name, TicketType ticketType) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        user.setName(name);
        session.saveOrUpdate(user);
        session.createQuery("UPDATE Ticket SET ticketType=:type WHERE userId=:id")
                .setParameter("type", ticketType)
                .setParameter("id", id)
                .executeUpdate();
        transaction.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }
}
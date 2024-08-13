package service;

import dao.UserDao;
import entities.Ticket;
import entities.User;
import enums.TicketType;

public class UserService {
    private UserDao userDao = new UserDao();

    public User findUser(int id) {
        return userDao.fetchUser(id);
    }

    public void createUser(User user) {
        userDao.save(user);
    }

    public void deleteUser(User user) {
        userDao.delete(user);
    }

    public void updateUser(int id, String name, TicketType type) {
        userDao.updateUserAndTicket(id, name, type);
    }
}

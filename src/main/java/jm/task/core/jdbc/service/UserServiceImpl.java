package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;


public class UserServiceImpl implements UserService {

    private final UserDao userDaoJDBCImpl = new UserDaoJDBCImpl();

    public void createUsersTable() {
        userDaoJDBCImpl.createUsersTable();
    }

    public void dropUsersTable() {
        userDaoJDBCImpl.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoJDBCImpl.saveUser(name, lastName, age);
        System.out.println("User with name " + name + " has been added to DB");
    }

    public void removeUserById(long id) {
        userDaoJDBCImpl.removeUserById(id);
    }

    public List<User> getAllUsers() {
        System.out.println("Print all rows of DB");
        return userDaoJDBCImpl.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoJDBCImpl.cleanUsersTable();
    }

}

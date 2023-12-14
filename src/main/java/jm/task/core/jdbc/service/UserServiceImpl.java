package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;


public class UserServiceImpl implements UserService {

    private final UserDao UDJI = new UserDaoJDBCImpl();
//    private final UserDao UDJI;

    public void createUsersTable() {
//        UserDaoJDBCImpl UDJI = new UserDaoJDBCImpl();
        UDJI.createUsersTable();
    }

    public void dropUsersTable() {
        UDJI.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        UDJI.saveUser(name, lastName, age);
        System.out.println("User with name " + name + " has been added to DB");
    }

    public void removeUserById(long id) {
        UDJI.removeUserById(id);
    }

    public List<User> getAllUsers() {
        System.out.println("Print all rows of DB");
        return UDJI.getAllUsers();
    }

    public void cleanUsersTable() {
        UDJI.cleanUsersTable();
    }

}

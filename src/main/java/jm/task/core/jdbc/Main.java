package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // DAO Hibernate v1.01
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("MarkH1", "Trunc", (byte) 28);
        userService.saveUser("MarkH2", "Talos", (byte) 29);
        userService.saveUser("MarkH3", "Head3", (byte) 28);
        userService.saveUser("MarkH4", "TSMC", (byte) 29);
//        userService.removeUserById(3);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();

        Util.closeSessionFactory();
    }
}

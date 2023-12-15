package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
//        UserServiceImpl userService = new UserServiceImpl();
//        userService.createUsersTable();
//        userService.saveUser("FYS", "SMD", (byte) 22);
//        userService.saveUser("She", "Her", (byte) 23);
//        userService.saveUser("Lock4", "Head2", (byte) 24);
//        userService.saveUser("MRN", "TSM", (byte) 25);
//        userService.getAllUsers();
//        userService.cleanUsersTable();
//        userService.dropUsersTable();
//        Util.closeConnection(); // static метод.

        // hibernate
        Util.closeSessionFactory();
    }
}

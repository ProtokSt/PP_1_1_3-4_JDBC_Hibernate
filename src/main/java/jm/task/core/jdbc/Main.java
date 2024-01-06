package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        // DAO Hibernate v1.02
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("MarkH1", "Trunc", (byte) 28);
        userService.saveUser("MarkH2", "Talos", (byte) 29);
        userService.saveUser("MarkH3", "Head3", (byte) 28);
        userService.saveUser("MarkH4", "TSMC", (byte) 29);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();

        Util.closeSessionFactory();
    }
}

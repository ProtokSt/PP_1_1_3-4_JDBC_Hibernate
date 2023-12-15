package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.*;
import java.util.Properties;

public class Util {
    private static String URL = "jdbc:mysql://localhost:3306/jpp_1_1_4";
    private static final String USERNANE = "root";
    private static final String PASSWORD = "1604javaSQL2023!";
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Driver driver = new com.mysql.cj.jdbc.Driver();
                DriverManager.registerDriver(driver);
            } catch (SQLException e) {
                System.err.println("Nope driver loading!?");
            }

            try {
                connection = DriverManager.getConnection(URL, USERNANE, PASSWORD);
                if (!connection.isClosed()) {
                    System.out.println("DB connection executed");
                }
                if (connection.isClosed()) {
                    System.out.println("DB connection closed");
                }
            } catch (SQLException e) {
                System.err.println("Nope connection!?");
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("connection closed");
            } catch (SQLException e) {
                System.err.println("connection.close problem");
            }
        }
    }
}

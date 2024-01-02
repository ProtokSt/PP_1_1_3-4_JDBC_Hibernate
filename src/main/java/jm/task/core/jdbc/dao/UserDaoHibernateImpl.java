package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private static final SessionFactory sessionFactory = Util.getSessionFactory();
    private static Session session = null;
    private String sqlCommand;

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        if (session == null) {
            session = sessionFactory.openSession();
        } else {
            session = sessionFactory.getCurrentSession();
        }
        try {
            session.beginTransaction();
            sqlCommand = "CREATE TABLE IF NOT EXISTS users (id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(45), lastName VARCHAR(45), age TINYINT) charset = utf8mb3";

            Query query = session.createSQLQuery(sqlCommand).addEntity(User.class);
            query.executeUpdate();

            session.getTransaction().commit();

        } catch (Exception e) {
            System.err.println("Create table problem");
        } finally {
            session.close();
        }
    }

    @Override
    public void dropUsersTable() {
        if (session == null) {
            session = sessionFactory.openSession();
        } else {
            session = sessionFactory.getCurrentSession();
        }
        try {
            session.beginTransaction();
            sqlCommand = "DROP TABLE IF EXISTS users";

            Query query = session.createSQLQuery(sqlCommand).addEntity(User.class);
            query.executeUpdate();

            session.getTransaction().commit();

        } catch (Exception e) {
            System.err.println("Drop table problem");
        } finally {
            session.close();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        if (session == null) {
            session = sessionFactory.openSession();
        } else {
            session = sessionFactory.getCurrentSession();
        }
        try {
            session.beginTransaction();
            session.save(new User(name, lastName, age));
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Saving user problem");
        } finally {
            session.close(); // закрываем повторно так как, если исключение, то коммит не закроет
        }
    }

    @Override
    public void removeUserById(long id) {
        if (session == null) {
            session = sessionFactory.openSession();
        } else {
            session = sessionFactory.getCurrentSession();
        }
        try {
            session.beginTransaction();

            User user = session.get(User.class, id);
            session.delete(user);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Removing user problem");
        } finally {
            session.close();
        }
    }

    public List<User> getAllUsersCriteria() {
        if (session == null) {
            session = sessionFactory.openSession();
        } else {
            session = sessionFactory.getCurrentSession();
        }
        // подготовка
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class); // корневой entity, основная таблица объектов
        cq.select(root); // получить все объекты
        // выполнение запроса
        Query query = session.createQuery(cq);
        List<User> userList = query.getResultList();
        session.close();

        // вывод в консоль
        for (User u : userList) {
            System.out.println(u);
        }

        return userList;
    }

    @Override
    public List<User> getAllUsers() {
        if (session == null) {
            session = sessionFactory.openSession();
        } else {
            session = sessionFactory.getCurrentSession();
        }
        session.beginTransaction();
        List<User> userList = session.createQuery("from User").getResultList();

        session.getTransaction().commit();

        // вывод в консоль
        for (User u : userList) {
            System.out.println(u);
        }
//        return null;
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        if (session == null) {
            session = sessionFactory.openSession();
        } else {
            session = sessionFactory.getCurrentSession();
        }
        try {
            session.beginTransaction();

            session.createQuery("delete User").executeUpdate();

            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Clean users table problem");
        } finally {
            session.close();
        }

    }
}

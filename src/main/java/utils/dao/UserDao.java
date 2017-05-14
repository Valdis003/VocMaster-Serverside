package main.java.utils.dao;


import main.java.entities.User;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDao {
    private SessionFactory factory;
    private EntityManager entityManager;

    protected UserDao(SessionFactory factory) {
        this.factory = factory;

        entityManager = factory.createEntityManager();
    }

    public User getUserByLoginAndPassword(String login, String password) {

        entityManager.getTransaction().begin();
        List<User> resultList = entityManager.createQuery("from User as u " +
                "where u.login = :login " +
                "and u.password = :password", User.class)
                .setParameter("login", login)
                .setParameter("password", password).getResultList();
        User user = null;
        if (resultList.size() != 0) {
            user = resultList.get(0);
        }
        entityManager.getTransaction().commit();
//        entityManager.close();
        return user;
    }

    public User getUserByLogin(String login) {

        entityManager.getTransaction().begin();
        List<User> resultList = entityManager.createQuery("from User as u " +
                "where u.login = :login ", User.class)
                .setParameter("login", login).getResultList();
        User user = null;
        if (resultList.size() != 0) {
            user = resultList.get(0);
        }
        entityManager.getTransaction().commit();
//        entityManager.close();
        return user;
    }

    public void createUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
//        entityManager.close();
    }


}

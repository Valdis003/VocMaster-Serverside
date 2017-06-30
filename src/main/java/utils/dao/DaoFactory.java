package main.java.utils.dao;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DaoFactory {

    private static DaoFactory ourInstance = new DaoFactory();
    private SessionFactory sessionFactory;
    private UserDao userDao;
    private WordDao wordDao;

    private DaoFactory() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static DaoFactory getInstance() {
        return ourInstance;
    }

    public UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDao(sessionFactory);
        }
        return userDao;
    }

    public WordDao getWordDao() {
        if (wordDao == null) {
            wordDao = new WordDao(sessionFactory);
        }

        return wordDao;
    }
}

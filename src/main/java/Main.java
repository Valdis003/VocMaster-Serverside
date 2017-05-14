package main.java;

import main.java.entities.Card;
import main.java.entities.Language;
import main.java.entities.User;
import main.java.entities.Word;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by Valdis003
 * on 13.05.2017
 * for VocMasterDist
 */
public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();

        Transaction transaction = session.beginTransaction();
        initTestData(session);
        transaction.commit();
        session.close();
    }

    private static void initTestData(Session session) {
        Language languageEN = new Language();
        languageEN.setName("english");
        languageEN.setShort_name("en");
        Language languageRUS = new Language();
        languageRUS.setName("russian");
        languageRUS.setShort_name("ru");

        Word word = new Word();
        word.setWord("yell");
        word.setLanguage(languageEN);

        Word wrd1 = new Word();
        wrd1.setWord("scream");
        wrd1.setLanguage(languageEN);
//        wrd1.getSynonyms().add(word);

        Word wrd2 = new Word();
        wrd2.setWord("кричать");
        wrd2.setLanguage(languageRUS);
//        wrd2.getTranslations().add(word);
//        wrd2.getTranslations().add(wrd1);

        Card card = new Card();
        card.setWord(word);
//        card.setTranslation(wrd2);

        User user = new User();
        user.setLogin("User1");
        user.setPassword("2345");
        user.setEmail("User1@gmail.com");
        user.getCards().add(card);

        session.save(word);
        session.save(wrd1);
        session.save(wrd2);
        session.save(card);
        session.save(user);
        session.save(languageEN);
        session.save(languageRUS);
    }
}

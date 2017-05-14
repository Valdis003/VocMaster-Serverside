package main.java.utils.dao;

import main.java.entities.Card;
import main.java.entities.Context;
import main.java.entities.Meaning;
import main.java.entities.Word;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Valdis003
 * on 14.05.2017
 * for VocMasterDist
 */
public class WordDao {
    private SessionFactory factory;
    private EntityManager entityManager;

    protected WordDao(SessionFactory factory) {
        this.factory = factory;

        entityManager = factory.createEntityManager();
    }


    public void saveWord(Word word) {
        entityManager.getTransaction().begin();
        entityManager.persist(word);
        entityManager.getTransaction().commit();
    }

    public void saveMeaning(Meaning meaning) {
        entityManager.getTransaction().begin();
        entityManager.persist(meaning);
        entityManager.getTransaction().commit();
    }

    public Word getWordByText(String word) {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("from Word where word = :text")
                .setParameter("text", word);
        List resultList = query.getResultList();

        entityManager.getTransaction().commit();

        return resultList.isEmpty() ? null : (Word) resultList.get(0);
    }

    public Word getWordById(int id) {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("from Word where id = :id")
                .setParameter("id", id);
        List resultList = query.getResultList();

        entityManager.getTransaction().commit();

        return resultList.isEmpty() ? null : (Word) resultList.get(0);
    }

    public void saveContext(Context context) {
        entityManager.getTransaction().begin();
        entityManager.persist(context);
        entityManager.getTransaction().commit();
    }

    public Meaning getMeaningById(int id) {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("from Meaning where id = :id")
                .setParameter("id", id);
        List resultList = query.getResultList();

        entityManager.getTransaction().commit();

        return resultList.isEmpty() ? null : (Meaning) resultList.get(0);
    }

    public void saveCard(Card card) {
        entityManager.getTransaction().begin();
        entityManager.persist(card);
        entityManager.getTransaction().commit();
    }
}

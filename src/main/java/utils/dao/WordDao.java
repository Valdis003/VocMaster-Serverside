package main.java.utils.dao;

import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;

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


//    public void saveSynonym(Synonym syn) {
//        entityManager.getTransaction().begin();
//        entityManager.persist(syn);
//        entityManager.getTransaction().commit();
//    }
//
//    public void saveTranslation(Translation trans) {
//        entityManager.getTransaction().begin();
//        entityManager.persist(trans);
//        entityManager.getTransaction().commit();
//    }
}

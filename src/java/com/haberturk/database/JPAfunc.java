package com.haberturk.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPAfunc {

    private EntityManager entityManager;
    private String persistenceName;

    public JPAfunc() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceName);
        entityManager = factory.createEntityManager();
    }
    
    public void getOperation(String operate, String entity) {
        entityManager.getTransaction().begin();
        Query q = entityManager.createNamedQuery(operate);
        // eksik kaldı. Bunu tamamla (tamamlanıyorsa)
        entityManager.getTransaction().commit();
    }

}

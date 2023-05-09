package org.example;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class AbstractRepository <T extends AbstractEntity, ID extends Serializable>{
    private EntityManager em = Persistence.createEntityManagerFactory("ExamplePU").createEntityManager();
    private final Class<T> clazz;

    public AbstractRepository() {
        Type type = getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) type;
        Type[] argTypes = paramType.getActualTypeArguments();
        clazz = (Class<T>) argTypes[0];
    }

    public void create(T entity) {
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }
    public T findById(ID id) {
        T returnVal;

        try {
            returnVal = em.find(clazz, id);

            if (returnVal == null) {
                throw new EntityNotFoundException("Nu a fost gasit nici un " + clazz + " care sa aibe id-ul : " + id);
            }
            return returnVal;
        } finally {
            em.close();
        }
    }

    public void persist(T entity) {
        try {
            beginTransaction();
            em.persist(entity);
            commit();
//            return true;
        } catch (Exception e) {
            handleException(e);
            rollback();
        }
    }

    public List<T> findByName(String name) {
        return em.createNamedQuery( this.getName() + ".findByName")
                .setParameter("name", name)
                .getResultList();
    }

    private void handleException(Exception e) {
        if (em != null && em.getTransaction().isActive()) {
            em.getTransaction().setRollbackOnly();
        }
    }

    private void rollback() {
        try {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } catch (RollbackException e) {
            throw new RuntimeException("Error during rollback", e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    private void commit() {
        em.getTransaction().commit();
    }

    private void beginTransaction() {
        em.getTransaction().begin();
    }

    public Class<T> getClazz(){
        return clazz;
    }

    public abstract String getName();

    EntityManager getEm() {
        return em;
    }
}

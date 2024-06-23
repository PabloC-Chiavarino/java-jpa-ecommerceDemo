package com.pdev.commerce_demo.managers;

import com.mysql.cj.xdevapi.Client;
import com.pdev.commerce_demo.entities.Product;
import jakarta.persistence.*;

import java.util.List;


public abstract class _GenericManager<T>  {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("commerce-demo-PU");
    private final Class<T> clazz;

    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void closeEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }



    public _GenericManager(Class<T> clazz) throws Exception {
        this.clazz = clazz;
    }



    public void save(T entity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
        finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    public T findById(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(clazz, id);
        } catch (Exception e) {
            throw e;
        }
        finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    // preparando para final
  /**  public List<T> findAll() {
        EntityManager em = getEntityManager();
        List<T> req;
        try {
            req = em.createQuery("SELECT e FROM " + clazz.getSimpleName() + " e").getResultList();
        } catch (Exception e) {
            throw e;
        }
        finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return req;
    }

    public void update(T entity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
        finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    public void delete(T entity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.contains(entity) ? entity : em.merge(entity));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
        finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    } */
}

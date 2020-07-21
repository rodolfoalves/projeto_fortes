package database_JPA;


import database_estrucuture.Dao_Cliente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClienteJpaDAO {
    private static ClienteJpaDAO instance;
    protected EntityManager entityManager;

    public static ClienteJpaDAO getInstance(){
        if (instance == null){
            instance = new ClienteJpaDAO();
        }

        return instance;
    }

    private ClienteJpaDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("crudHibernatePU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public Dao_Cliente getById(final int id) {
        return entityManager.find(Dao_Cliente.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Dao_Cliente> findAll() {
        return entityManager.createQuery("FROM " +
                Dao_Cliente.class.getName()).getResultList();
    }

    public void persist(Dao_Cliente cliente) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Dao_Cliente cliente) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Dao_Cliente cliente) {
        try {
            entityManager.getTransaction().begin();
            cliente = entityManager.find(Dao_Cliente.class, cliente.getID());
            entityManager.remove(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final int id) {
        try {
            Dao_Cliente cliente = getById(id);
            remove(cliente);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

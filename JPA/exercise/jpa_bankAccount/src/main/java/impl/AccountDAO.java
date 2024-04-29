package impl;

import dao.IBaseDAO;
import entity.Account;
import entity.BranchBank;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class AccountDAO implements IBaseDAO<Account> {
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;
    private EntityTransaction transaction;

    public AccountDAO(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }


    @Override
    public boolean createAndSave(Account element) {
        if (element.getCodeIban() == null || element.getBalance() == null) {
            // Gérer le cas où des propriétés obligatoires sont nulles
            return false;
        }

        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(element);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }


    @Override
    public boolean update(Account element) {
        return false;
    }

    @Override
    public Account getById(Long id) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
           Account account = entityManager.find(Account.class,id);
            if(account != null){
                entityManager.remove(account);
                transaction.commit();
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }finally {
            entityManager.close();
        }
    }

    @Override
    public List getAll() {
        entityManager = entityManagerFactory.createEntityManager();
        List<Account> accounts = entityManager.createQuery("SELECT c FROM Account c, Account .class").getResultList();
        entityManager.close();
        return accounts;
    }
}

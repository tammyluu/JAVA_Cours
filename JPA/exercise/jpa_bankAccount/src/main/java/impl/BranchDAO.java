package impl;

import dao.IBaseDAO;
import entity.BranchBank;
import entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class BranchDAO implements IBaseDAO<BranchBank> {
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;
    private EntityTransaction transaction;

    public BranchDAO(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }




    public boolean createAndSave(BranchBank element) {
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(element);
            transaction.commit();
            return true;
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
    public boolean update(BranchBank element) {
        return false;
    }





    @Override
    public BranchBank getById(Long id) {
        entityManager = entityManagerFactory.createEntityManager();
        BranchBank bank = entityManager.find(BranchBank.class, id);
        entityManager.close();
        return bank;
    }

    @Override
    public boolean deleteById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            BranchBank bank = entityManager.find(BranchBank.class, id);
            if (bank != null) {
                entityManager.remove(bank);
            }
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
    public List getAll() {
        entityManager = entityManagerFactory.createEntityManager();
        List<BranchBank> branchBankList = entityManager.createQuery("SELECT b FROM BranchBank b, BranchBank.class").getResultList();
        entityManager.close();
        return branchBankList;
    }
}

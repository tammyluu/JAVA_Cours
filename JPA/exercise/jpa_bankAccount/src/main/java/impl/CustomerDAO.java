package impl;

import dao.IBaseDAO;
import entity.Account;
import entity.BranchBank;
import entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CustomerDAO implements IBaseDAO <Customer> {
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;
    private EntityTransaction transaction;

    public CustomerDAO(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
    @Override
    public boolean createAndSave(Customer customer) {
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(customer);
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
    private  boolean addCustomerByBranch(Customer customer, Long branchId){
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            BranchBank branch = entityManager.find(BranchBank.class, branchId);
            if ( branch != null){
                // Ajouter le Customer à la liste des customers de la Branch
              // branch.addCustomer(element);
                entityManager.persist(customer);
                transaction.commit();
                return true;
            }else {
                // La branch associée à l'ID n'existe pas
                System.out.println("La branche associée à l'ID " + branchId + " n'existe pas.");
                transaction.rollback();
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
    public boolean update(Customer element) {
        return false;
    }

    @Override
    public Customer getById(Long id) {
       return null;

    }

    @Override
    public boolean deleteById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
           Customer customer = entityManager.find(Customer.class,id);
            if(customer != null){
                entityManager.remove(customer);
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
    public List<Customer> getAll() {
        entityManager = entityManagerFactory.createEntityManager();
        List<Customer> customers = entityManager.createQuery("SELECT c FROM Customer c, Customer .class").getResultList();
        entityManager.close();
        return customers;
    }
}

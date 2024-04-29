package impl;

import dao.InfoDAO;
import dao.TaskDAO;
import entity.Info;
import entity.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class InfoDAOImpl implements InfoDAO {
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction;
    private Task task;

    public InfoDAOImpl(EntityManagerFactory emf, EntityManager em, EntityTransaction transaction) {
        this.emf = emf;
        this.em = em;
        this.transaction = transaction;
    }

    public InfoDAOImpl(EntityManagerFactory emf) {
    }

    @Override
    public boolean addInfo(Info info) {
        em = emf.createEntityManager();
        transaction = em.getTransaction();

       task = em.find(Task.class, task.getId());

        try {
            transaction.begin();
            em.persist(info);
            transaction.commit();
            return true;
        }catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }finally {
            em.close();
        }
    }

    @Override
    public List<Info> getAllInfos() {
       em = emf.createEntityManager();
        List<Info> infos = em.createQuery("SELECT i FROM Info i",Info.class).getResultList();
        em.close();
        return infos;
    }

    @Override
    public boolean deleteInfo(Long infoId) {
        em = emf.createEntityManager();
        transaction = em.getTransaction();
        try {
            transaction.begin();
            Task task = em.find(Task.class,infoId);
            if(task != null){
               em.remove(task);
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
            em.close();
        }
    }
}

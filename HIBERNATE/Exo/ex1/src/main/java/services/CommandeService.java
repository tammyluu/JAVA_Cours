package services;

import dao.DAOInterface;
import models.Commande;
import org.hibernate.Transaction;

import java.util.List;

public class CommandeService extends  BaseService implements DAOInterface<Commande> {
    @Override
    public List<Commande> selectAll() {
        return null;
    }

    @Override
    public Commande selectById(int id) {
        session = null;

        try {
            session = sessionFactory.openSession();
            Commande commande =  session.get(Commande.class, id);
            return commande;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();

        }
        return null;
    }

    @Override
    public boolean addNew(Commande commande) {
        session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(commande);
            session.getTransaction().commit();
            return true;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();

        }
        return false;
    }

    @Override
    public void update(Commande commande, int id) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Commande> searchByPrice(Double prix) {
        return null;
    }

    @Override
    public List<Commande> getByStock(int stock) {
        return null;
    }
}

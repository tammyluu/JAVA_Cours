package services;

import dao.DAOInterface;
import models.Image;
import models.Produit;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class ImageService extends BaseService implements DAOInterface<Image> {

    public void begin() {

        session = sessionFactory.openSession();

    }

    public void end() {

        session.close();
    }

    @Override
    public List<Image> selectAll() {
        return null;
    }

    @Override
    public Image selectById(int id) {
        return null;
    }

    @Override
    public boolean addNew(Image image) {
        Transaction transaction = null;
        try {
            begin();
            transaction = session.beginTransaction();
            session.save(image);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
       return false;

    }

    @Override
    public void update(Image image, int id) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Image> searchByPrice(Double prix) {
        return null;
    }

    @Override
    public List<Image> getByStock(int stock) {
        return null;
    }


}



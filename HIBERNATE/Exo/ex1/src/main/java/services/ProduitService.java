package services;

import dao.DAOInterface;
import models.Comment;
import models.Image;
import models.Produit;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProduitService extends BaseService  implements DAOInterface<Produit> {
    @Override
    public List<Produit> selectAll() {
        begin();
        session.beginTransaction();
        List<Produit> produitList = new ArrayList<>();
        Query<Produit> produitQuery = session.createQuery("from Produit");
        produitList = produitQuery.list();
        end();
        return produitList;
    }

    @Override
    public Produit selectById(int id) {
        begin();
        session.beginTransaction();
        Produit produit = session.get(Produit.class, id);
        session.getTransaction().commit();
        end();
        return produit;
    }

    @Override
    public boolean addNew(Produit produit) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(produit);
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
    public void update(Produit produit, int id) {
        begin();
        session.beginTransaction();
        Produit p = selectById(id);
        p.setMarque(produit.getMarque());
        p.setReference(produit.getReference());
        p.setDateAchat(produit.getDateAchat());
        p.setPrix(produit.getPrix());
        p.setStock(produit.getStock());
        session.update(produit);
        session.getTransaction().commit();
        System.out.println("Produit bien modifié");
        ;
    }

    @Override
    public void delete(int id) {
        begin();
        session.beginTransaction();
        Produit p = session.get(Produit.class, id);
        if (p != null) {
            session.delete(p);
        }

        session.getTransaction().commit();
        end();
        System.out.println("Votre produit suprimé !!!!");
    }

    @Override
    public List<Produit> searchByPrice(Double prix) {
        begin();
        session.beginTransaction();
        List<Produit> produits = new ArrayList<>();
        Query<Produit> produitQuery = session.createQuery("from Produit where prix >: prix");
        produitQuery.setParameter("prix", prix);
        produits = produitQuery.list();
        return produits;
    }


    @Override
    public List<Produit> getByStock(int stock) {

        try {
            begin();
            session.getTransaction().begin();
            List<Produit> produits = new ArrayList<>();
            if (stock > 0) {
                Query<Produit> productQuery = session.createQuery("from Produit where stock < :stock");
                productQuery.setParameter("stock", stock);
                produits = productQuery.list();
                return produits;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            end();
        }
        return null;
    }

    public List<Produit> filterByPrice(double min) throws Exception {
        if (min >= 0) {
            Query<Produit> produitQuery = session.createQuery("from Produit where prix >= :min");

            return produitQuery.list();
        }
        throw new Exception("erreur valeur");
    }

    public List<Produit> filterByDate(Date min, Date max) throws Exception {
        if (min.before(max)) {

            Query<Produit> produitQuery = session.createQuery("from Produit where dateAchat >= :min and dateAchat <= :max ");
            produitQuery.setParameter("min", min);
            produitQuery.setParameter("max", max);

            return produitQuery.list();
        }
        throw new Exception("erreur date");
    }

    public List<Double> amountOfStockByBrand(String marque) {
        begin();
        session.beginTransaction();
        List<Double> stockList = new ArrayList<>();
        Query<Double> stockQuery = session.createQuery("select  (stock * prix) from Produit where marque like : marque");
        stockQuery.setParameter("marque", marque);
        stockList = stockQuery.list();
        end();
        return stockList;

    }

    private void begin() {
        session = sessionFactory.openSession();
    }

    public Double calculPriceAverage() {
        //Session session = null;
        try {
            begin();
            session.beginTransaction();
            Query<Double> productQuery = session.createQuery("select avg(prix) from Produit ");
            double prixMoyen = productQuery.uniqueResult();
            return prixMoyen;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            end();
        }
        return null;
    }

    public List<Produit> selectAllByBrand(String marque) {
        begin();
        session.beginTransaction();
        List<Produit> produits = new ArrayList<>();
        Query<Produit> productQuery = session.createQuery("from Produit where marque like :marque");
        productQuery.setParameter("marque", marque);
        produits = productQuery.list();
        end();
        return produits;
    }

    public void removeProductByBrand(String marque) {
       /* begin();
        List<Produit> produits = selectAllByBrand(marque);
        for (Produit p: produits ) {
            session.delete(p);
        }
        session.getTransaction().commit();
        end();*/

        begin();
        session.beginTransaction();

        Query<Produit> deleteQuery = session.createQuery("delete from Produit where marque = :marque");
        deleteQuery.setParameter("marque", marque);
        deleteQuery.executeUpdate();
        end();


    }

    private void end() {
        session.close();
    }
    public void addImageByProduct(Image image, int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Produit produit = session.get(Produit.class, id);

            if (produit != null) {
                image.setProduit(produit);
                session.save(image);

                transaction.commit();
            } else {
                System.out.println("Produit non trouvé avec l'ID : " + id);
            }
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

    }
    public  void addCommentsByProduit(Comment comment, int id){
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Produit produit = session.get(Produit.class, id);

            if (produit != null) {
                comment.setProduit(produit);
                session.save(comment);

                transaction.commit();
            } else {
                System.out.println("Produit non trouvé avec l'ID : " + id);
            }
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
    }
    public List<Produit> selectProductByRanking(){
        try {
            begin();
            Query<Produit> query = session.createQuery(
                    "select distinct p from Produit p join p.comments c where c.note > 4"
            );
            List<Produit> produits = query.list();
            return produits;
        }catch (Exception e){
            e.printStackTrace();

        }finally {
            end();
        }
        return null;
    }
}

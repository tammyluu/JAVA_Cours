package demo;

import demo.model.Personne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class Demo1 {

    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // HQl
        Query<Personne> personneQuery = session.createQuery("from Personne");

        List<Personne> personneList = personneQuery.list();
        for (Personne p: personneList) {
            System.out.println("Personne : " + p);
        }

        Iterator<Personne> personneIterator = personneQuery.iterate();

        while (personneIterator.hasNext()){
            Personne p = personneIterator.next();
            System.out.println("Personne avec iterator " + p);
        }

        // une requête avec filter pour récupérer une liste :

        Query<Personne> personneQuery2 = session.createQuery("from Personne where nom = 'LeFrancais'");
        List<Personne> list = personneQuery2.list();
        for (Personne p: list) {
            System.out.println("Personne avec un nom en paramètre : " + p);
        }

        Query<Personne> personneQuery3 = session.createQuery("from Personne where id = 2");
        Personne personne2 = personneQuery3.getSingleResult();

        System.out.println("Une seule personne : " + personne2);

    }



}

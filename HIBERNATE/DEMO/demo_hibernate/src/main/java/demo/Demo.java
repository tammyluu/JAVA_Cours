package demo;

import demo.model.Personne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Demo {

    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // créer une personne :

        Personne p = new Personne();
        p.setAge(35);
        p.setNom("LeFrancais");
        p.setPrenom("Francois");
        session.save(p);

        System.out.println("Personne : " + p.getId());

        // récupérer une personne :


        /*Personne personne = session.load(Personne.class, 1L);
        System.out.println("Personne : " + personne.getNom());

        // Modification personne :

        personne.setPrenom("Mathias");
        session.update(personne);

        System.out.println("Personne change " + personne);

        //Delete personne :

        session.delete(personne);*/

        session.getTransaction().commit();

        session.close();
        sessionFactory.close();


    }


}

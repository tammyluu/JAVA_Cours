package demo;

import demo.model.Personne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.type.StringType;

import java.util.List;

public class Demo2 {

    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String search = "P";
        // Recherche de personnes avec un paramètre nomme avec like

        Query<Personne> personneQuery = session.createQuery("from Personne where prenom like :prenom");
        personneQuery.setParameter("prenom", search + "%", StringType.INSTANCE);
        List<Personne> personnesStartWithP = personneQuery.list();

        for (Personne p : personnesStartWithP) {
            System.out.println("Personne avec prenom qui démarre par P " + p);
        }

        Query<Personne> personneQuery2 = session.createQuery("from Personne where prenom like ?1");
        personneQuery2.setParameter(1,search+"%",StringType.INSTANCE );
        List<Personne> personnesStartWithP2 = personneQuery.list();

        for (Personne p: personnesStartWithP2) {
            System.out.println("Personne avec prenom qui démarre par P " + p);
        }



    }
}

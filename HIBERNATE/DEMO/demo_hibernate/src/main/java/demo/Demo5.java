package demo;

import demo.embedded.Agence;
import demo.embedded.AgenceID;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Demo5 {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        AgenceID agenceID = new AgenceID(12345,"Lille-République");
        Agence agence = new Agence("Rue Léon Gambetta", agenceID);
        session.save(agence);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}

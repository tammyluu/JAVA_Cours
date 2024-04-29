package demo;

import demo.model.Personne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Demo3 {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        // fonction d'aggregations:
        // un max()
        Query<Integer> query = session.createQuery("select max(age) from  Personne ");
        int maxAge = query.uniqueResult();
        System.out.println("Age max : " + maxAge);
        // avg()
        double moyenneAge = (double)session.createQuery("select avg(age) from  Personne ").uniqueResult();
        System.out.println("Moyenne age : "+ moyenneAge);

        //utisateur In
        List noms = new ArrayList<String>();
        noms.add("Dubois");
        noms.add("Julie");
        Query<Personne> query1 = session.createQuery("from Personne where  nom in :noms");
        query1.setParameter("noms", noms);
        List<Personne > personneList = query1.list();
        for (Personne p: personneList
             ) {
            System.out.println(p);
        }
        // utilisation execute update
        String update_query = "update Personne set nom = :nomP where id=2";
        Query query3 = session.createQuery(update_query);
        query3.setParameter("nomP", "Romain");



    }
}

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import pojo.Category;
import pojo.Manufacturer;
import pojo.Product;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo2 {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            Category c = session.get(Category.class,3);

            Manufacturer m1 = session.get(Manufacturer.class,1);
            Manufacturer m2 = session.get(Manufacturer.class,2);

            Product p = new Product();
            p.setName("IPAD Mini  4");
            p.setDescription("IPAD Mini 128GB");
            p.setPrice(new BigDecimal(26));
            p.setCategory(c);
            Set<Manufacturer> m  = new HashSet<>();
            m.add(m1);
            m.add(m2);
            p.setManufacturers(m);



            session.save(p);
            session.getTransaction().commit();
            System.out.println(p);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        // update categorie
        Query q = session.createQuery("UPDATE Category C SET C.name = :name WHERE C.id = :id");
        q.setParameter("id", 2);
        q.setParameter("name", "PC");
        q.executeUpdate();
        session.getTransaction().commit();
        System.out.println("Votre produit modifié!");




    }
}

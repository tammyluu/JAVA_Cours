import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import pojo.Category;
import pojo.Product;

import java.math.BigDecimal;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

       /* Session session = sessionFactory.openSession();
        session.beginTransaction();
*/
        /*Category c = new Category();
        c.setName("Phone");
        session.save(c);
        Category c1 = new Category();
        c1.setName("PC");
        session.save(c1);
        Category c2 = new Category();
        c2.setName("Tablette");
        session.save(c2);
        session.getTransaction().commit();*/
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query<Category> query = session.createQuery("FROM Category ");
            List<Category> cats = query.list();
            cats.forEach(category -> System.out.println(category.getName()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }

       // sessionFactory.close();

        try {
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            Category c = session.get(Category.class,1);
            Product p = new Product();
            p.setName("iPhone Pro 2023");
            p.setDescription("Apple, 128GB");
            p.setPrice(new BigDecimal(35));
            p.setCategory(c);
            session.save(p);
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

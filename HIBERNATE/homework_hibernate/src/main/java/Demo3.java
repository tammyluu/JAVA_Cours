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
import java.util.Objects;
import java.util.Set;

public class Demo3 {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            /*Manufacturer m = new Manufacturer();
            m.setName("Samsung");
            m.setCountry("Korean");
            session.save(m);

            Manufacturer m1 = new Manufacturer();
            m1.setName("Apple");
            m1.setCountry("America");
            session.save(m1);
            session.getTransaction().commit();*/

           /* Category c = session.get(Category.class,1);
            c.getProducts().forEach(product -> System.out.println(product.getName()));*/
            /*Manufacturer m2 = session.get(Manufacturer.class,2);
            m2.getProducts().forEach(product -> System.out.println(product.getName()));
*/

            //afficher la liste de fournisseurs
            Query<Manufacturer> query = session.createQuery("FROM Manufacturer ");
            List<Manufacturer> manufacturers = query.list();
            System.out.println("--------List de fournisseurs----------");
            manufacturers.forEach(manufacturer-> System.out.println(manufacturer.getName()));

            //afficher tous les produits
            Query<Product> query1 = session.createQuery("FROM Product ");
            List<Product> prod = query1.list();
            System.out.println("--------List de produits----------");
            prod.forEach(p-> System.out.println(p));

            //affichier 3 attributes (colonnes) de la table product
            Query q = session.createQuery("SELECT P.id , P.name, P.price FROM Product P " );
            // retour un object ARRAY car ce n'est pas un Obj Product complet => cast
            List<Object[]> products = q.list();
            System.out.println("-----------List de produits-------------- : ");
            products.forEach(p -> System.out.printf("%d| %-30s| %.2f\n", p[0],p[1],p[2]));

            //affichier les produits avec param
            Query query2 = session.createQuery("SELECT P.id , P.name, P.price FROM Product P WHERE P.id = :id" );
            query2.setParameter("id", 3);

            List<Object[]> productsList = query2.getResultList();
            System.out.println("--------Produit avec id = 3 est :------------- : ");
            productsList.forEach(p -> System.out.printf("%d| %-30s| %.2f\n", p[0],p[1],p[2]));

            //affichier les produits avec param "LIKE"
            Query query3 = session.createQuery("SELECT P.id , P.name, P.price FROM Product P WHERE P.name like :kw" );
            query3.setParameter("kw","%iPhone%" );

            List<Object[]> prods = query3.getResultList();
            System.out.println("--------Produit avec nom contenant iphone sont  :------------- : ");
            prods.forEach(p -> System.out.printf("%d| %-30s| %.2f\n", p[0],p[1],p[2]));

            //affichier les produits avec param "LIKE"
            Query query4 = session.createQuery("SELECT P.id , P.name, P.price FROM Product P WHERE P.name like :kw ORDER BY P.price ASC " );
            query4.setParameter("kw","%iP%" );

            List<Object[]> prodList = query4.getResultList();
            System.out.println("--------Produits avec les prix décroissants sont  :------------- : ");
            prodList.forEach(p -> System.out.printf("%d| %-30s| %.2f\n", p[0],p[1],p[2]));

            //calcul nbr de produits dans un catégorie et le prix max, min

            Query hql = session.createQuery("SELECT C.name, Count(P.id), Max(P.price) , Min(P.price)" +
                    " FROM Product P RIGHT OUTER JOIN Category C ON P.category.id= C.id GROUP BY C.name" );
            List<Object[]> results = hql.getResultList();
            System.out.println("--------Produits détails sont  :------------- : ");
            results.forEach(objects -> System.out.printf("\nName: %-10s| Count: %d| Max: %.2f| Min: %.2f",objects[0], objects[1],objects[2],objects[3]));


        }catch (Exception e){
            e.printStackTrace();
        }




    }
}

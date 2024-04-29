package heritage;


import heritage.table_per_class.CreditCardPayment2;

import heritage.table_per_class.PayPalPayment2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;

public class Demo_per_class  {
 public static void test(){
     StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
     SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

     Session session = sessionFactory.openSession();
     Transaction tx = null;

     try {
         tx = session.getTransaction();
         tx.begin();
            // table per class
         CreditCardPayment2 creditCardPayment2 = new CreditCardPayment2();
         creditCardPayment2.setCardNumber("852456");
         creditCardPayment2.setPaymentDate(new Date());
         creditCardPayment2.setExpirationDate("02/2029");
         creditCardPayment2.setAmount(25602.10);

         PayPalPayment2 paypalPayment2 = new PayPalPayment2();
         paypalPayment2.setAccountNumber("963258");
         paypalPayment2.setPaymentDate(new Date());
         paypalPayment2.setAmount(9645.80);
         session.save(creditCardPayment2);
         session.save(paypalPayment2);

         tx.commit();
         System.out.println("creditCardPayment2 " + creditCardPayment2);
         System.out.println("paypalPayment2 " + paypalPayment2);

     } catch (Exception ex) {
         if (tx != null) {
             tx.rollback();
             ex.printStackTrace();
         }
     } finally {
         session.close();
         sessionFactory.close();
     }

}
}

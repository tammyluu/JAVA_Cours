package heritage;


import heritage.joined_table.CreditCardPayment;
import heritage.joined_table.PayPalPayment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;

public class Demo_joined_table {
    public void test(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.getTransaction();
            tx.begin();
            // Exemple joined table :

            CreditCardPayment creditCardPayment = new CreditCardPayment();
            creditCardPayment.setCardNumber("178456");
            creditCardPayment.setAmount(4000.0);
            creditCardPayment.setPaymentDate(new Date());
            creditCardPayment.setExpirationDate("12/2026");


            PayPalPayment paypalPayment = new PayPalPayment();
            paypalPayment.setAccountNumber("45878");
            paypalPayment.setPaymentDate(new Date());
            paypalPayment.setAmount(10000.0);

            session.save(creditCardPayment);
            session.save(paypalPayment);

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




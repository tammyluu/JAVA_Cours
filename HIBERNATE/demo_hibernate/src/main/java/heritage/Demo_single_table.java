package heritage;

import heritage.single_table.CreditCardPayment1;
import heritage.single_table.PayPalPayment1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;

public class Demo_single_table {
    public static void test() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.getTransaction();
            tx.begin();
            // single table

            CreditCardPayment1 creditCardPayment = new CreditCardPayment1();
            creditCardPayment.setCardNumber("123456");
            creditCardPayment.setPaymentDate(new Date());
            creditCardPayment.setExpirationDate("02/2025");
            creditCardPayment.setAmount(98214.10);

            PayPalPayment1 paypalPayment = new PayPalPayment1();
            paypalPayment.setAccountNumber("741852");
            paypalPayment.setPaymentDate(new Date());
            paypalPayment.setAmount(2560.0);
            session.save(creditCardPayment);
            session.save(paypalPayment);

            tx.commit();
            System.out.println("creditCardPayment " + creditCardPayment);
            System.out.println("paypalPayment " + paypalPayment);

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
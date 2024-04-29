
import heritage.Demo_per_class;
import heritage.table_per_class.CreditCardPayment2;
import heritage.table_per_class.PayPalPayment2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Demo_per_class.test();

    }
}

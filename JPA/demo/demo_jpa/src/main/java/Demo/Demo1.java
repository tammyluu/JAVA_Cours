package Demo;

import entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Demo1 {

 private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_jpa");
 public static void  main(){

     EntityManager em = emf.createEntityManager();
     em.getTransaction().begin();

     Person person = new Person("Tom", "Cruise");
     person.setAge(45);
     em.persist(person);
     System.out.println("New Person is  " + person.getId());
     em.getTransaction().commit();
     em.close();
     emf.close();

 }
public static void find(){
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();

    Person person = em.find(Person.class, 2L);
    System.out.println(person);
    em.close();
    emf.close();
}
    public static void remove(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person person = em.find(Person.class, 2L);
        em.remove(person);
        em.getTransaction().commit();
        System.out.println(person);
        em.close();
        emf.close();
    }
    public static void  createQuery(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person person = new Person("Tom", "Cruise");
        Person person1 = new Person("Lady", "Gaga");
        em.persist(person);
        em.persist(person1);
        List<Person> personList = null;
        personList = em.createQuery("select p from Person  p ", Person.class).getResultList();

        for (Person p : personList  ) {
            System.out.println(p);
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
    }


}

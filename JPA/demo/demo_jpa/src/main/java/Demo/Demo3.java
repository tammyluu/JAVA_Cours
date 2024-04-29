package Demo;

import entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Demo3 {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_jpa");
    public static void create(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person person = new Person("Julia", "Robert");
        person.setAge(45);
        em.persist(person);
        System.out.println("New Person is  " + person.getId());
        em.getTransaction().commit();
        em.close();
        emf.close();


     }
     public static  void merge (){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
         Query query = em.createQuery("select p from Person p where p.id = 14");
         Person p = (Person)query.getSingleResult();
         if (p == null){
             System.out.println("Person not found ");
         }else {
             System.out.println( p.toString());
             Person person1 = new Person();
             person1.setId(p.getId());
             person1.setPrenom(p.getPrenom());
             person1.setNom("Robert");

             em.merge(person1);
             p = (Person) query.getSingleResult();
             System.out.println( "Nom à jour : "+ p.getNom());
             System.out.println(p);
         }

         em.getTransaction().commit();
         em.close();
         emf.close();

     }
    public static void refresh() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            Person person = em.find(Person.class,16L);
            System.out.println( person);
            if(person == null){
                System.out.println("Person not found");
            }else{
                Thread.sleep(15000);

                em.refresh(person);
                System.out.println("Person : " + person);

            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        em.close();
        emf.close();





    }



}

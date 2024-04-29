package Demo;

import entity.Person;

import javax.persistence.*;
import java.util.List;

public class Demo2 {
    public static void main(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transac = em.getTransaction();

        transac.begin();
        Person person = null;

        try{
           person = em.getReference(Person.class, 1L); // .getReference() = .find()
           // System.out.println(person);
        }catch (EntityNotFoundException e){
            System.out.println("Entity not found : " + e.getMessage());
        }
        //em.remove(person);
        // récupération par query
        // singleResult :

        Query query = em.createQuery("select p from Person p where p.nom = 'Nguyen'");
        Person person2 = (Person) query.getSingleResult();
        System.out.println(person2);

        // resultList
        Query query1 = em.createQuery("select p from Person p where p.id > 3 ");
        List<Person> personList = query1.getResultList();
        for ( Person p : personList ) {
            System.out.println(" List of Person :  " + p.getNom());
        }

        // paramères nommés :
        Query query2 = em.createQuery("select p from Person p where p.id > :id");
        query2.setParameter("id", 3L);
        List<Person> personList2 = query2.getResultList();
        for ( Person p : personList2 ) {
            System.out.println(" List of Person is found with his parameter :  " + p.getNom());
        }
        System.out.println("----- Modifier une occurrence ---------");
        Person person4 = em.find(Person.class, 4L);
        person4.setNom("Nguyen");
        person4.setPrenom("Tammy");


        transac.commit();
        person4 = em.find(Person.class, 4L);
        System.out.println("Person : " + person4);

        System.out.println("----- RollBack ---------");
        em = emf.createEntityManager();
        em.getTransaction().begin();

        Person person6 = new Person("Jimmy", "Paul");
        em.persist(person6);
        // rollback only person has id == 11
        if (person6.getId() == 11){
            System.out.println("Person is:  " + person6.getId()+ " " +person6.getNom());
            transac.rollback();
        }else {
            em.getTransaction().commit();
            System.out.println("Person is: " + person6.getId() + " " +person6.getNom());
        }
        // native query . it's depend to option (join, ....specific)
        System.out.println("-----native query ---------");
        List<Person> list = em.createNativeQuery("SELECT * FROM  person", Person.class).getResultList();
        for (Person p : list ) {
            System.out.println("p : " + p);
        }
        em.close();
        emf.close();
    }


}

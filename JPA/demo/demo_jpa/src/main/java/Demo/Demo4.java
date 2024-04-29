package Demo;

import entity.OneToOne.Address;
import entity.OneToOne.House;
import entity.OneToOne.Type;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo4 {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_jpa");
    public static void main(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Address address = new Address();
        address.setNumero(46);
        address.setNomRue("Rue Léon Gambetta");
        address.setCodePostal("59000");
        address.setVille("Lille");


        House house = new House(500, Type.OLD,address);
        em.persist(address);
        em.persist(house);

        em.getTransaction().commit();
        House house1 = em.find(House.class, house.getId());
        System.out.println(house1);
    }
}

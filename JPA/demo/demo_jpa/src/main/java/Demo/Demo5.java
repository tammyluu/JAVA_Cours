package Demo;

import entity.ManytoOne.Departement;
import entity.ManytoOne.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Demo5 {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_jpa");
public  static void main (){
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();

   /* Employee employee = new Employee();
    Employee employee1 = new Employee();
    employee.setName("Michel");
    employee1.setName("Patrick");

    Departement departement = new Departement();
    departement.setDepName("Comtable");
    employee.setDepartement(departement);
    List<Employee> employeeList = new ArrayList<>();

    employeeList.add(employee);
    employeeList.add(employee1);

    departement.setEmployeeList(employeeList);
    em.persist(departement);
    em.getTransaction().commit();

    Departement departement1 = em.find(Departement.class, 3L);

    for (Employee e: departement1.getEmployeeList() ) {
        System.out.println(e);
    }*/

    Departement departement = em.find(Departement.class, 3L);
    System.out.println(departement);
    em.close();
    emf.close();

}

}

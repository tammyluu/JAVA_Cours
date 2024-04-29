//import models.Produit;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import services.ProduitService;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class Test {
//    public static void main(String[] args) {
//        ProduitService ps = new ProduitService();
//        ps.begin();
//
//        // Exercice 1
//
//        // Creation des produits
//
//        ps.addNew(new Produit("TOSHIBA","zzaa123",new Date("2016/01/08"),6000));
//        ps.addNew(new Produit("HP","EER678",new Date("2016/02/09"),2000));
//        ps.addNew(new Produit("SONY","AQWZSX",new Date("2016/09/23"),6000));
//        ps.addNew(new Produit("DELL","AZERTY",new Date("2016/02/12"),6000));
//        ps.addNew(new Produit("SONY","qsdERT",new Date("2016/02/02"),6000));
//
//        // Informations produit id = 2
//
//        Produit p = ps.selectById(2);
//        System.out.println(p);
//
//        // Supprimer le produit id = 3
//        //ps.delete(ps.selectById(2));
//
//        // Modifier produit id = 1
//
//        p = ps.selectById(1);
//        if(p != null){
//            p.setMarque("HP");
//            p.setReference("MMMMPPP");
//            p.setDateAchat(new Date("2015/09/08"));
//            p.setPrix(5000);
//            ps.update(p,1);
//        }
//
//
//        // Exercice 2
//
//        System.out.println("############################");
//        System.out.println("Afficher tous les produits");
//        System.out.println("############################");
//        List<Produit> produits = ps.selectAll();
//        for (Produit pr: produits) {
//            System.out.println(pr.getId() + " " + pr.getReference());
//        }
//        System.out.println("############################");
//        System.out.println("produits avec filtre prix");
//        System.out.println("############################");
//
//        try{
//            List<Produit> produits1 = ps.filterByPrice(4000);
//            for (Produit pr: produits1) {
//                System.out.println(pr.getId() + " " + pr.getReference());
//            }
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        System.out.println("############################");
//        System.out.println("produits avec filtre date");
//        System.out.println("############################");
//
//        try{
//            List<Produit> produits2 = ps.filterByDate(new Date("2016/01/20"),new Date("2016/12/23"));
//            for (Produit pr: produits2) {
//                System.out.println(pr.getId() + " " + pr.getReference());
//            }
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//
//    }
//}

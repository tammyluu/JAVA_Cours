package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "order")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Double total;

    @Temporal(TemporalType.DATE)
    private Date dateCommande;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( name = "order_product",
    joinColumns = @JoinColumn(name = "id_order"),
    inverseJoinColumns = @JoinColumn(name = "id_prod"))
    private List<Produit> produits = new ArrayList<>();

    public Commande(Double total, Date date, List<Produit> productList, Adresse adress) {
    }


    @Override
    public String toString() {
        return "Commande " +
                " | id = " + id +
                " | total = " + total +
                " | dateCommande = " + dateCommande +
                " | produits = " + produits +
                '|';
    }
}

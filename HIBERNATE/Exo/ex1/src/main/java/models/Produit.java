package models;

import jdk.jfr.DataAmount;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "product")
@Data
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String marque;
    private String reference;

    @Temporal(TemporalType.DATE)
    private Date dateAchat;
    private double prix;
    private int stock;

    @OneToMany(mappedBy = "produit",fetch = FetchType.LAZY)
    private List<Image> images = new ArrayList<>();
    @OneToMany(mappedBy = "produit",fetch = FetchType.EAGER)
    private List<Comment> comments = new ArrayList<>();

    public Produit() {
    }

    public Produit(String marque, String reference, Date dateAchat, double prix) {
        this.marque = marque;
        this.reference = reference;
        this.dateAchat = dateAchat;
        this.prix = prix;
    }



    public void setMarque(String marque) {
        this.marque = marque;
    }

    @Override
    public String toString() {
        return "Produit" +
                " |id = " + id +
                " | marque = '" + marque + '\'' +
                " | reference = '" + reference + '\'' +
                " | dateAchat = " + dateAchat +
                " | prix = " + prix +
                " | stock = " + stock +
                " | images = " + images +
                " | comments = " + comments +
                " | ";
    }
}

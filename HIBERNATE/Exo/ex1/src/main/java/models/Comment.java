package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String contenu;
    @Temporal(TemporalType.DATE)
    private Date dateCommentaire = new Date();
    private int note;
    @ManyToOne
    @JoinColumn(name = "id_prod")
    private Produit produit;
    @OneToOne(mappedBy = "commande")
    private Adresse adresse;

    public Comment(String contenu, Date dateCommentaire, int note) {
        this.contenu = contenu;
        this.dateCommentaire = dateCommentaire;
        this.note = note;
    }

}

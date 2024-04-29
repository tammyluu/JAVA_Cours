package demo.composeKey;

import java.io.Serializable;
import java.util.Objects;

public class EmployeePK  implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nom;
    private String prenom;

    public EmployeePK() {
    }
    public EmployeePK(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeePK)) return false;
        EmployeePK that = (EmployeePK) o;
        return Objects.equals(nom, that.nom) && Objects.equals(prenom, that.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom);
    }
}

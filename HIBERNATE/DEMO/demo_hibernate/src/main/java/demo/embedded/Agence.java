package demo.embedded;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Agence {
    private  String adresse;
    @EmbeddedId
    private AgenceID agenceID;

    public Agence() {
    }

    public Agence(String adresse, AgenceID agenceID) {
        this.adresse = adresse;
        this.agenceID = agenceID;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public AgenceID getAgenceID() {
        return agenceID;
    }

    public void setAgenceID(AgenceID agenceID) {
        this.agenceID = agenceID;
    }
}

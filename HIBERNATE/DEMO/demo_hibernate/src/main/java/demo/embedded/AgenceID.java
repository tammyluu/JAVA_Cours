package demo.embedded;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AgenceID implements Serializable {

    private int code;
    private  String libelle;

    public AgenceID() {
    }

    public AgenceID(int code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AgenceID)) return false;
        AgenceID agenceID = (AgenceID) o;
        return getCode() == agenceID.getCode() && Objects.equals(getLibelle(), agenceID.getLibelle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getLibelle());
    }
}

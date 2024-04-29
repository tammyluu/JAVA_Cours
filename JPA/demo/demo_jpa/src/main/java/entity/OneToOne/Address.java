package entity.OneToOne;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    private Long id;
    @Column(nullable = false)
    private  Integer numero;
    @Column(name = "nom_rue", nullable = false)
    private String nomRue;
    @Column(name = "code_postal",nullable = false, length = 5)
    private String codePostal;
    private String ville;
    @OneToOne(mappedBy = "address") // exact with instance  Address  address in class House
    private House house;

    public Address() {
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNomRue(String rueLéonGambetta) {
        return nomRue;
    }

    public void setNomRue(String nomRue) {
        this.nomRue = nomRue;
    }

    public String getCodePostal(String number) {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille(String lille) {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Address|" +
                " id = " + id +
                "| numero = " + numero +
                "| nomRue = '" + nomRue + '\'' +
                "| codePostal = '" + codePostal + '\'' +
                "| ville = '" + ville + '\'' +
                '|';
    }
}

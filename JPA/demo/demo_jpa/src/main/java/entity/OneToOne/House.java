package entity.OneToOne;

import javax.persistence.*;

@Entity
@Table(name = "maison")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_maison")
    private Long id;
    private  Integer taille;
    @Enumerated(EnumType.STRING)
    private Type type;
    @OneToOne
    @JoinColumn(name = "adresse_id",referencedColumnName = "id_address")
    //name of FK wille be put on house 's table, which colum PK of address table
    private Address address;

    public House() {
    }

    public House( Integer taille, Type type, Address address) {

        this.taille = taille;
        this.type = type;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTaille() {
        return taille;
    }

    public void setTaille(Integer taille) {
        this.taille = taille;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "House |" +
                " id = " + id +
                "| taille = " + taille +
                "| type = " + type +
                "| address = " + address +
                '|';
    }
}

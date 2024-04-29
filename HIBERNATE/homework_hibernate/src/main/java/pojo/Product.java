package pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String name;
    private String description;
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cat_id")
    private Category category;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prod_manufacturer",
            joinColumns = @JoinColumn(name = "prod_id"),
            inverseJoinColumns = @JoinColumn(name = "manufacturer_id"))
    private Set<Manufacturer> manufacturers = new HashSet<>();

    public Product() {
    }

    public Product(String name, String description, BigDecimal price, Category category, Set<Manufacturer> manufacturers) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.manufacturers = manufacturers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(Set<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }

    @Override
    public String toString() {
        return "Product |" +
                "id=" + id +
                "| name = '" + name + '\'' +
                "| description = '" + description + '\'' +
                "| price = " + price +
                "| category = " + category +
                "| manufacturers = " + manufacturers +
                '|';
    }
}

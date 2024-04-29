package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "infos")
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_info")
    private Long id;
    private String description;
    @Column(name = "Date_d'echeance ")
    private String date;
    @Enumerated(EnumType.STRING)
    @Column(name = "priorite")
    private  Type type;
    @OneToOne(mappedBy = "info")
    private Task task;

    public Info(){
    }

    public Info(String description, String date, Type type) {
        this.description = description;
        this.date = date;
        this.type = type;
    }

    public Info(Task task) {
        this.task = task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Info |" +
                " description = '" + description + '\'' +
                "| date = " + date +
                "| type = " + type +
                '|';
    }
}

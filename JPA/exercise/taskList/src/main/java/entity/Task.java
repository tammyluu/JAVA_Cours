package entity;




import javax.persistence.*;

@Entity
@Table(name= "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private boolean completed;
    @OneToOne
    @JoinColumn(name = "info_id", referencedColumnName = "id_info") // qui port FK
    private Info info;

    public Task() {
    }

    public Task(String title, boolean completed, Info info) {
        this.title = title;
        this.completed = completed;
        this.info = info;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Task |" +
                " id =" + id +
                "| title = '" + title + '\'' +
                "| completed = " + completed +
                "| info = " + info +
                '|';
    }
}

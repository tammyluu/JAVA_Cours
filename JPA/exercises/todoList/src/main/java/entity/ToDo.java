package entity;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Table(name = "Task")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String title;
   private boolean status;

    public ToDo() {
    }

    public ToDo(String title, boolean status) {
        this.title = title;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", status=" + status +
                '}';
    }
    public void showTasks(){
        System.out.printf("|%5d|%25s|%15s|", id, title,status);
    }
}

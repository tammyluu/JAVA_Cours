package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameCat;
    @ManyToMany
    @JoinTable(name = "category_task",
                       joinColumns = @JoinColumn(name = "cat_id"),
                        inverseJoinColumns = @JoinColumn(name = "task_id"))
    private List<Task> taskList =new ArrayList<>();

    public Category() {
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNameCat() {
        return nameCat;
    }

    public void setNameCat(String nameCat) {
        this.nameCat = nameCat;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    @Override
    public String toString() {
        return "Category |" +
                " id = " + id +
                "| nameCat = '" + nameCat + '\'' +
                "| taskList = " + taskList +
                '|';
    }
}

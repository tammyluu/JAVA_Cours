package org.example.entity;

public class Todo {
    private Long id;
    private String content;
    private Boolean status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Todo(String content, Boolean status) {
        this.content = content;
        this.status = status;
    }

    public Todo(Long id, String content, Boolean status) {
        this.id = id;
        this.content = content;
        this.status = status;
    }
}

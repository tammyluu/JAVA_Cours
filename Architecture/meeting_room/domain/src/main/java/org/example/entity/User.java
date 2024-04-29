package org.example.entity;

public class User {
    private int id;
    private String username;
    private String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public  User(Builder builder){
        this.setId(builder.id);
        this.setUsername(builder.username);
        this.setEmail(builder.email);
    }
    public static class Builder{
        private int id;
        private String username;
        private String email;
        public Builder id(int id){
            this.id = id;
            return this;
        }
        public Builder username(String username){
            this.username = username;
            return this;
        }
        public  Builder email(String email){
            this.email = email;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }
}

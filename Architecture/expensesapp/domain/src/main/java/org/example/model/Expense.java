package org.example.model;

public class Expense {
    private Long id;

    private String title;

    private double sum;

    private Expense(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.sum = builder.sum;
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

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public static class Builder {
        private Long id;
        private String title;
        private double sum;


        public Builder(String title, double sum) {
            this.title = title;
            this.sum = sum;
        }

        public Builder() {

        }


        public Builder id(Long id) {
            this.id = id;
            return this;

        }
        public Builder title(String title) {
            this.title = title;
            return this;

        }

        public Builder sum(double sum) {
            this.sum = sum;
            return this;

        }

        public Expense build() {
            return new Expense(this);
        }
    }


    }

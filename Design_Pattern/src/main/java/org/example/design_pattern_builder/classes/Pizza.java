package org.example.design_pattern_builder.classes;
import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String taille;
    private String typePate;
    private String fromage;
    private List<String> garnitures;
    private String typeSauce;

    private Pizza(Builder builder) {
        fromage = builder.fromage;
        taille = builder.taille;
        typeSauce = builder.typeSauce;
        typePate = builder.typePate;
        garnitures = builder.garnitures;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "taille='" + taille + '\'' +
                ", typePate='" + typePate + '\'' +
                ", fromage='" + fromage + '\'' +
                ", garnitures=" + garnitures +
                ", typeSauce='" + typeSauce + '\'' +
                '}';
    }

    public static class Builder {
        private String taille;
        private String typePate;
        private String fromage;
        private List<String> garnitures = new ArrayList<>();
        private String typeSauce;

        public Builder taille(String taille) {
            this.taille = taille;
            return this;
        }
        public Builder typePate(String typePate) {
            this.typePate = typePate;
            return this;
        }
        public Builder fromage(String fromage) {
            if(this.fromage != null)
                throw new RuntimeException("Un fromage a déjà été choisi");
            this.fromage = fromage;
            return this;
        }
        public Builder garnitures(String garniture) {
            this.garnitures.add(garniture);
            return this;
        }
        public Builder typeSauce(String typeSauce) {
            this.typeSauce = typeSauce;
            return this;
        }
        public Pizza build() {
            return new Pizza(this);
        }
    }
}

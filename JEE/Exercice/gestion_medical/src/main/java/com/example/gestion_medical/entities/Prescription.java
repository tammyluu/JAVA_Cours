package com.example.gestion_medical.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String typeOfDrug;
    private String during;
    @OneToMany(mappedBy = "prescription")
    private List<Consultation> consultations;

    public Prescription() {
    }
}
package com.example.gestion_medicalev2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prescription")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String typeOfDrug;
    private String during;
    @OneToMany(mappedBy = "prescription")
    private List<Consultation> consultations;

}
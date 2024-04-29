package com.example.gestion_medicalev2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "patient_sheet")
public class PatientSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String typeOfCare;
    private String during;
    @OneToMany(mappedBy ="patientChart" )
    private List<Consultation> consultations;
}
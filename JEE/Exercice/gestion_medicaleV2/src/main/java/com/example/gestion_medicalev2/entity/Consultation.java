package com.example.gestion_medicalev2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Temporal(TemporalType.DATE)
    private Date consultdate;
    private  String doctorName;
    @OneToMany(mappedBy = "consultation")
    private List<Patient> patients;

    @ManyToOne
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;
    @ManyToOne
    @JoinColumn(name = "patientChart_id")
    private PatientSheet patientChart;


}

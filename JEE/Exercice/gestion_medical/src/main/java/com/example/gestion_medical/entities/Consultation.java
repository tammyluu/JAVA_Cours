package com.example.gestion_medical.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data

@Entity
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
    private PatientChart patientChart;



    public Consultation() {
    }
}

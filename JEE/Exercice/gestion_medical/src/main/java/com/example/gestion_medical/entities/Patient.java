package com.example.gestion_medical.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String lastName;
    private  String firstName;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private  byte[] image;
    @ManyToOne
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;
    public Patient() {
    }

    public Patient(String lastName, String firstName, Date dateOfBirth, byte[] image) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.image = image;
    }

    public Patient(String lastName, String firstName, Date dateOfBirth, byte[] image, Consultation consultation) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.image = image;
        this.consultation = consultation;
    }
}

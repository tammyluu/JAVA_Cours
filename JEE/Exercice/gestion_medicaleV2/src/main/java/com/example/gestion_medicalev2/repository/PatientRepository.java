package com.example.gestion_medicalev2.repository;

import com.example.gestion_medicalev2.entity.Patient;

import java.util.List;

public class PatientRepository extends Repository<Patient> {
    public PatientRepository() {

    }

    @Override
    public Patient findById(int id) {
        return session.get(Patient.class, id);
    }

    @Override
    List<Patient> findAll() {
        return session.createQuery("from Patient ").list();
    }
}
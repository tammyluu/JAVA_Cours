package com.example.gestion_medicalev2.repository;

import com.example.gestion_medicalev2.entity.Consultation;

import java.util.List;

public class ConsultationRepository  extends Repository<Consultation> {
    public  ConsultationRepository (){

    }
    @Override
    Consultation findById(int id) {
         return session.get(Consultation.class, id);
    }

    @Override
    List<Consultation> findAll() {
        return session.createQuery("from Consultation ").list();
    }
}

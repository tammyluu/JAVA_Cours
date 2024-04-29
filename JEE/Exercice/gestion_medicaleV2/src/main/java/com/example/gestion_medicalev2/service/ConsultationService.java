package com.example.gestion_medicalev2.service;

import com.example.gestion_medicalev2.entity.Consultation;
import com.example.gestion_medicalev2.entity.Patient;
import com.example.gestion_medicalev2.exception.RepositoryException;
import com.example.gestion_medicalev2.repository.PatientRepository;
import com.example.gestion_medicalev2.repository.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

public class ConsultationService {
    Repository<Consultation> consultationRepository;
    SessionFactory sessionFactory;
    PatientRepository patientRepository;

    public ConsultationService(Repository<Consultation> consultationRepository, SessionFactory sessionFactory) {
        this.consultationRepository = consultationRepository;
        this.sessionFactory = sessionFactory;
    }
    public  boolean createConsultation(int patientId, Date consultdate, String doctorName) throws RepositoryException {
        boolean result = false;
        Session session = sessionFactory.openSession();

        consultationRepository.setSession(session);
        // Obtient le patient à partir de l'identifiant fourni
        Patient patient = patientRepository.findById(patientId);
        if (patient == null) {
            // Le patient n'existe pas, une exception.
            throw new IllegalArgumentException("Patient with ID " + patientId + " not found.");
        }

        Consultation consultation = Consultation.builder()
                .consultdate(consultdate)
                .doctorName(doctorName)
                .build();
        session.beginTransaction();
        try{
            consultationRepository.create(consultation);
            session.getTransaction().commit();
            result = true;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw new RepositoryException();
        }finally {
            session.close();
        }
        return result;
    }

}

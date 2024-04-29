package com.example.hospital.services;

import com.example.hospital.entities.Patient;
import com.example.hospital.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Set;

public class PatientService extends BaseService implements Repository <Patient> {
    @Override
    public boolean create(Patient o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Patient o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Patient o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Patient findById(int id) {
        Patient patient= null;
        session = sessionFactory.openSession();
        patient = (Patient) session.get(Patient.class, id);
        session.close();
        return patient;
    }

    @Override
    public List<Patient> findAll() {
        List<Patient> patients = null;
        session = sessionFactory.openSession();
        Query<Patient> produitQuery = session.createQuery("from Patient");
        patients = produitQuery.list();
        session.close();
        return patients;
        
    }
  
}

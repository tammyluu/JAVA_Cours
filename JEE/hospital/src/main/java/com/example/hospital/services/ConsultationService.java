package com.example.hospital.services;

import com.example.hospital.entities.Consultation;
import com.example.hospital.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class ConsultationService extends BaseService implements Repository <Consultation> {
    @Override
    public boolean create(Consultation o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Consultation o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Consultation o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Consultation findById(int id) {
         Consultation consult = null;
        session = sessionFactory.openSession();
        consult = (Consultation) session.get(Consultation.class, id);
        session.close();
        return consult;
    }

    @Override
    public List<Consultation> findAll() {
        List<Consultation> consultList = null;
        session = sessionFactory.openSession();
        Query<Consultation> consultQuery = session.createQuery("from Consultation");
        consultList = consultQuery.list();
        session.close();
        return consultList;
    }
}

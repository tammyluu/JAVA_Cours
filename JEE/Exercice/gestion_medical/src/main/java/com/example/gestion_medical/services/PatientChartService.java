package com.example.gestion_medical.services;

import com.example.gestion_medical.entities.PatientChart;
import com.example.gestion_medical.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class PatientChartService extends BaseService implements Repository<PatientChart> {
    @Override
    public boolean create(PatientChart o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(PatientChart o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(PatientChart o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public PatientChart findById(int id) {
        PatientChart chart = null;
        session = sessionFactory.openSession();
        chart = (PatientChart) session.get(PatientChart.class, id);
        session.close();
        return chart;
    }

    @Override
    public List<PatientChart> findAll() {
        List<PatientChart> chartList = null;
        session = sessionFactory.openSession();
        Query<PatientChart> chartQuery = session.createQuery("from PatientChart");
        chartList = chartQuery.list();
        session.close();
        return chartList;
    }
}

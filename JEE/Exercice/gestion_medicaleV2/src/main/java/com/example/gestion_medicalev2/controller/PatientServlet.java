package com.example.gestion_medicalev2.controller;

import com.example.gestion_medicalev2.repository.PatientRepository;
import com.example.gestion_medicalev2.service.PatientService;
import com.example.gestion_medicalev2.util.HibernateSession;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(name = "patient", value = "/patient")
public class PatientServlet extends HttpServlet {

    private PatientService patientService;


    public void init() {
        patientService = new PatientService(HibernateSession.getSessionFactory(), new PatientRepository());
    }
    private

}
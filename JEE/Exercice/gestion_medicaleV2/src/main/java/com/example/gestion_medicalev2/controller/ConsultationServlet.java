package com.example.gestion_medicalev2.controller;

import com.example.gestion_medicalev2.repository.ConsultationRepository;
import com.example.gestion_medicalev2.service.ConsultationService;
import com.example.gestion_medicalev2.util.HibernateSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
@WebServlet(name = "consultation" , value = "/consultation")
public class ConsultationServlet extends HttpServlet {
    private ConsultationService consultationService;

    @Override
    public void init() throws ServletException {
        consultationService = new ConsultationService(new ConsultationRepository(), HibernateSession.getSessionFactory());
    }
}

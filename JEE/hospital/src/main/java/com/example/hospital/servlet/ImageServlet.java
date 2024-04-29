package com.example.hospital.servlet;

import com.example.hospital.entities.Patient;
import com.example.hospital.services.PatientService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;
@WebServlet("/imageServlet")
public class ImageServlet {

    private PatientService service;

    public void init() {

        service = new PatientService();

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Patient patien = service.findById(id);
        response.setContentType("image/png");
        OutputStream out = response.getOutputStream();
        if (patien.getImage() != null) {
            out.write(patien.getImage());
        } else {
            out.write(null);
        }
        out.close();
    }
}

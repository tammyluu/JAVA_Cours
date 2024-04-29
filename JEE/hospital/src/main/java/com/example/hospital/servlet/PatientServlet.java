package com.example.hospital.servlet;

import com.example.hospital.entities.Patient;
import com.example.hospital.services.PatientService;
import com.example.hospital.utils.Definition;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@WebServlet("/")
@MultipartConfig(maxFileSize = 1024*1024*10)
public class PatientServlet  extends HttpServlet {
    private PatientService patientService;

    @Override
    public void init() throws ServletException {
        patientService = new PatientService();

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        boolean logged = (session.getAttribute("isLogged") != null) ? (boolean)session.getAttribute("isLogged") : false;

        if(logged){

            String action = req.getServletPath();

            switch (action) {
                case "/new":
                    showNewForm(req,resp);
                    break;
                case "/insert":
                    insertPatient(req,resp);
                    break;

                case "/edit":
                    showEditForm(req,resp);
                    break;
                case "/details":
                    showPatient(req,resp);
                    break;
                case "/update":
                    updatePatient(req,resp);
                    break;
                case "/list":
                    listPatient(req,resp);
                    break;
                default:
                    listPatient(req,resp);
                    break;
            }
        }else{
            resp.sendRedirect("login.jsp");
        }
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
    }

    private void listPatient(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
    }

    private void updatePatient(HttpServletRequest req, HttpServletResponse resp)   throws ServletException, IOException{
    }

    private void showPatient(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
    }

   

    private void insertPatient(HttpServletRequest req, HttpServletResponse resp)   throws ServletException, IOException {
        Part imagePart = req.getPart("image");

        String fileType = imagePart.getContentType();
        if (fileType.equalsIgnoreCase("image/png")) {

            byte[] imageBytes = null;
            if (imagePart != null) {
                InputStream inputStream = imagePart.getInputStream();
                imageBytes = inputStream.readAllBytes();
            }
            String lastName = req.getParameter("lastName");
            String firstName = req.getParameter("firstName");
            LocalDate dateBirth = LocalDate.parse(req.getParameter("dateOfBirth"));
            Patient patient = new Patient(lastName, firstName, Date.from(dateBirth.atStartOfDay(ZoneId.systemDefault()).toInstant()), imageBytes);
            System.out.println(patient);
            Integer id = req.getParameter("id") !=null ? Integer.valueOf(req.getParameter("id")) : null;

            if(id != null){
                patient.setId(id);
            }

            if(patientService.create(patient)) {
                resp.sendRedirect("list");
            }else{
                resp.sendRedirect(Definition.VIEW_PATH+"form-patient.jsp");
            }
        }else{
            resp.sendRedirect(Definition.VIEW_PATH+"form-patient.jsp");
        }
        }

    }

   


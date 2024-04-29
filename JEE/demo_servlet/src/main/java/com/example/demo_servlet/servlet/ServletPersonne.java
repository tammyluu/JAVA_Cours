package com.example.demo_servlet.servlet;

import com.example.demo_servlet.model.Personne;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "personne", value = "/personne")
public class ServletPersonne extends HttpServlet {
    private List<Personne> personneList;
    @Override
    public void init() throws ServletException {
        personneList = new ArrayList<>();
        Personne personne = new Personne("Aulas"," Jean-Michel");
        Personne personne1 = new Personne("Martin"," MontBlanc");
        personneList.add(personne);
        personneList.add(personne1);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        Personne personne = new Personne(nom, prenom);
        personneList.add(personne);
        //pour dans personnses dans jsp
        req.setAttribute("personnes",personneList);
        // s'interesse une fois request, une fois reponse
        req.getRequestDispatcher("personne-list.jsp").forward(req,resp);


    }
}

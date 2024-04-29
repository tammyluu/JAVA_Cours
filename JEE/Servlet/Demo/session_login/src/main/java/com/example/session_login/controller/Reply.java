package com.example.session_login.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "reply" ,value = "/reply")
public class Reply  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name" );
        List<String> list ;
        HttpSession session = req.getSession();
        if(session.getAttribute("names") == null){
            list = new ArrayList<>();
        }
        // because it is an obj, cast in list
        list = (List<String>) session.getAttribute("names");
        list.add(name);
        //recreate a session car list is increased one name
        session.setAttribute("names", list);
        req.getRequestDispatcher("form.jsp");

    }
}

package com.example.demo_servlet.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="protected", value="/protect")
public class ProtectedServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        boolean logged = false;

        Cookie[] cookies = req.getCookies();

        for (Cookie c: cookies) {
            if(c.getName().equals("isLogged") && c.getValue().equals("true")){
                out.println("<div>Connecté</div>");
                logged = true;
                break;
            }
        }
        if(!logged){
            out.println("<div> Pas connecté </div>");
        }

        out.println("</body></html>");
    }
}

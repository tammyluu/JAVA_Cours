package com.example.produit.servlet;

import com.example.produit.entities.User;
import com.example.produit.service.ProduitService;
import com.example.produit.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "register", value = "/register")
public class RegisterServlet  extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService  = new UserService();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String us = req.getParameter("username");
        String pw = req.getParameter("password");
        User user = new User(name,email,us,pw);
        userService.create(user);
        HttpSession session = req.getSession(false);
        session.setAttribute("theLastestUser", user);


        //enregistrer dans la listes users enregistrés
        ArrayList<User> userList = null;
        if(session.getAttribute("userList") != null) {
            userList = (ArrayList<User>) session.getAttribute("userList");
        } else {
            userList = new ArrayList<>();
        }
        userList.add(user);
        session.setAttribute("userList", userList);
        req.getRequestDispatcher("welcome.jsp").forward(req,resp);

       /*// return name;
        return name;*/
    }
}

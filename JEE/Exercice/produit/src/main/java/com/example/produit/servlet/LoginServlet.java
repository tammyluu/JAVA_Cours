package com.example.produit.servlet;

import com.example.produit.entities.User;
import com.example.produit.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService;
    @Override
    public void init() throws ServletException {
        userService = new UserService();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login-form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("msg", "");
        String uname = req.getParameter("username");
        String pw= req.getParameter("password");
        //1 validate
        //not null & not space
        boolean isUsernameOk = uname != null && uname.trim().length() > 0;
        boolean isPasswordOk = pw != null && pw.trim().length() > 0;
        if (isUsernameOk && isPasswordOk){
            //2 .check DB (fake)
            if (uname.equals("username") && pw.equals("paswword")){
                // 3. save session
                    HttpSession session = req.getSession();
                    session.getAttribute(Constants.USER_LOGGED);

                //4. save cookies (remember ME)

                // redirect home page index.jsp
                resp.sendRedirect(req.getContextPath() +"/");
            }
        }else {
            //message = > validate
        }








    }
}

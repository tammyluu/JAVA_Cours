package com.example.produit.servlet;

import com.example.produit.entities.Produit;
import com.example.produit.service.ProduitService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "produitPrice", value = "/produitPrice")
public class FiltreProduit extends HttpServlet {
    private List<Produit> produitList;
    private ProduitService produitService;
    @Override
    public void init() throws ServletException {

        produitService = new ProduitService();
        produitList = produitService.findAll();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String marque = req.getParameter("marque");
        try {
            produitList = produitService.filterByPrice(20);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("prodFiltre", produitList);
        req.getRequestDispatcher("by-price.jsp").forward(req,resp);
    }
}

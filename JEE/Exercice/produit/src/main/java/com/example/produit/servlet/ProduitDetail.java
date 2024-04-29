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

@WebServlet(name = "produitDetail", value = "/produitDetail")
public class ProduitDetail extends HttpServlet {
    private List<Produit> produitList;
    private ProduitService produitService;
    @Override
    public void init() throws ServletException {

        produitService = new ProduitService();
        produitList = produitService.findAll();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // detail un produit
        // Récupérer l'ID du produit à partir du paramètre de requête
        String idParameter = req.getParameter("id");
        if (idParameter != null) {
            int id = Integer.parseInt(idParameter);
            Produit produitDetail = produitService.findById(id);

            if (produitDetail != null) {
                req.setAttribute("produit", produitDetail);
            } else {
                req.setAttribute("message", "Aucun produit trouvé pour l'ID spécifié");
            }
        }
        // Rediriger vers la page JSP pour afficher les détails du produit
        req.getRequestDispatcher("detail-produit.jsp").forward(req, resp);
    }


}

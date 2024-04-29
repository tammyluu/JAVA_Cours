package com.example.produit.servlet;

import com.example.produit.entities.Produit;
import com.example.produit.service.ProduitService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.eclipse.tags.shaded.org.apache.bcel.classfile.Constant;
import org.hibernate.exception.ConstraintViolationException;

import java.io.File;
import java.io.IOException;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.eclipse.tags.shaded.org.apache.bcel.classfile.Constant.*;

@WebServlet(name="produit", value = "/produit")
@MultipartConfig(maxFileSize = 1024*1024*10)
public class ProduitServlet extends HttpServlet {
    private List<Produit> produitList;
    private ProduitService produitService;
    public String image1 = "";

    @Override
    public void init() throws ServletException {
        produitService = new ProduitService();
        produitList = produitService.findAll();

    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String marque = req.getParameter("marque");
        String ref = req.getParameter("reference");
        //String dateAchat = req.getParameter("dateAchat");
        double prix = 0;
        int stock = 0;
        try {
            prix = Double.parseDouble(req.getParameter("prix"));
            stock = Integer.parseInt(req.getParameter("stock"));
           /* Part part = req.getPart("image");
            String realPath = req.getServletContext().getRealPath("/images");
            String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
            if (!Files.exists(Path.of(realPath))){
                Files.createDirectory(Path.of(realPath));
            }
            if (!ServletFileUpload.isMultipartContent((RequestContext) req)) {
                resp.getWriter().println("Error: This servlet requires a multipart request.");

            }
            part.write(realPath + "/" + req.getParameter("image"));
            PrintWriter out = resp.getWriter();*/

            Produit produit = new Produit();
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            try {
                List<FileItem> items = servletFileUpload.parseRequest((javax.servlet.http.HttpServletRequest) req);
                for (FileItem item : items) {
                    if (item.getFieldName().equals("id")) {
                        produit.setId((Integer.parseInt(item.getString())));
                    } else if (item.getFieldName().equalsIgnoreCase("marque")) {
                        produit.setMarque(item.getString());

                    } else if (item.getFieldName().equalsIgnoreCase("reference")) {
                        produit.setReference(item.getString());

                    } else if (item.getFieldName().equals("prix")) {
                        produit.setPrix((Double.parseDouble(item.getString())));

                    } else if (item.getFieldName().equals("stock")) {
                        produit.setStock((Integer.parseInt(item.getString())));

                    } else if (item.getFieldName().equalsIgnoreCase("image")) {
                        if (item.getSize() > 0) {
                            String originalFileName = item.getName();
                            int index = originalFileName.lastIndexOf(".");
                            String ext = originalFileName.substring(index + 1);
                            String fileName = System.currentTimeMillis() + "." + ext;
                            // Vérifier l'existence du répertoire
                           /* File dir = new File(Constant.DIR);
                            if (!dir.exists()) {
                                dir.mkdirs(); // Créer le répertoire s'il n'existe pas
                            }
                            //File file = new File(Constant.DIR + "/" + fileName);
                            File file = new File(dir, fileName);
                            item.write(file);
                            produit.setImage(fileName);*/
                        } else {
                            produit.setImage(image1);
                        }

                    }
                    System.out.println(produit);
                    //set data to produitService

                }
                produitService.update(produit);
                resp.sendRedirect("");
            } catch (FileUploadException e) {
                throw new RuntimeException(e);
            }


        }catch (Exception e) {
            throw new RuntimeException(e);
        }
            req.setAttribute("produits", produitList);

        }

        @Override
        protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            produitList = produitService.findAll();
            req.setAttribute("produits", produitList);
            // s'interesse une fois request, une fois reponse
            req.getRequestDispatcher("list-produits.jsp").forward(req, resp);


        }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        Produit produit = produitService.findById(id);
        produitService.delete(produit);
        req.setAttribute("produit", produit);
        resp.getWriter().println("supprimé !!");
        resp.sendRedirect("list-produits.jsp");
    }
}



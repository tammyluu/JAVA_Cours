package com.example.demo_servlet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
@WebServlet(name = "upload", value = "/upload")
@MultipartConfig(maxFileSize = 1024*1024*10)
public class UploadServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //où? "/" point d'entrée mon project
        String uploadPath = getServletContext().getRealPath("/") + "images";
        File file = new File( uploadPath);
        // si n'existe pas => create a folder
        if(!file.exists()){
            file.mkdir();
        }
        // part = i'infos récupérer , image est value de name dans fiche jsp  form-upload :  <input type="file" name="image"/>
        Part image = req.getPart("image");

        // nomer le fichier, recuperer son nom
        String fileName = image.getSubmittedFileName();

        //comment stocker l'image, save
        image.write( uploadPath + File.separator + fileName );




    }
}

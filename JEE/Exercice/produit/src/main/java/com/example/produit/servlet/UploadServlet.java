package com.example.produit.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

@WebServlet(name = "upload", value = "/upload")
@MultipartConfig(maxFileSize = 1024*1024*10)
public class UploadServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uploadPath = getServletContext().getRealPath("/") + "images";
        File file = new File( uploadPath);

        if(!file.exists()){
            file.mkdir();
        }

        Part image = req.getPart("image");


        String fileName = image.getSubmittedFileName();


        image.write( uploadPath + File.separator + fileName );
        try {
            PrintWriter out = resp.getWriter();
            out.print("<img src='images/" + fileName + "' width='100' height='100'>");
        }catch (Exception e){
            e.printStackTrace();
        }




//get file upload by name field
      /*  try {
            Part part = req.getPart("image");
            String reelPath = req.getServletContext().getRealPath("/images");
            String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
            if (!Files.exists(Path.of(reelPath))){
                Files.createDirectory(Path.of(reelPath));
            }
            part.write(reelPath + "/" + fileName);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

*/
req.getRequestDispatcher("uploadfile.jsp").forward(req,resp);

    }
}



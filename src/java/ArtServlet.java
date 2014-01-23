
import ges_bdd.Connexion;
import java.io.*;
import java.sql.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ArtServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        if (ServletFileUpload.isMultipartContent(request)) {
            out.println("dans upload");
            String UPLOAD_DIRECTORY = "pictures";
            out.println(UPLOAD_DIRECTORY + "\n");
//                if (!ServletFileUpload.isMultipartContent(request)) {
//                    // gestion si n'est pas multi part
//                    out.println("Error: Form must has enctype=multipart/form-data.");
////                    return;
//                }
            // configures upload settings
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // sets temporary location to store files
            factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

            ServletFileUpload upload = new ServletFileUpload(factory);

                // constructs the directory path to store upload file
            // this path is relative to application's directory
            String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
            // creates the directory if it does not exist
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            try {
                out.println("dans le try\n");
                // parses the request's content to extract file data
                @SuppressWarnings("unchecked")
                List<FileItem> formItems = upload.parseRequest(request);
                out.println("contenur requets parse: " + upload.parseRequest(request) + " \n");
                if (formItems != null && formItems.size() > 0) {
                    // iterates over form's fields
                    out.println("dans le if item\n");
                    for (FileItem item : formItems) {
                        // processes only fields that are not form fields
                        if (!item.isFormField()) {
                            String fileName = new File(item.getName()).getName();
                            String filePath = uploadPath + File.separator + fileName;
                            out.println(filePath + "\n");
                            out.println(fileName);
                            File storeFile = new File(filePath);

                            // saves the file on disk
                            item.write(storeFile);
                            request.setAttribute("message",
                                    "Upload has been done successfully!");
                        }
                    }
                }
            } catch (Exception ex) {
                out.println("erreur upload");
            }
        } else {
            response.setContentType("text/html");
            Connexion connect = new Connexion(); // instanciation et ouverture de la base de donnée.
            String formulaire_origine = request.getParameter("div_type_form");
//        out.print(formulaire_origine);
            try {
                if (formulaire_origine.equals("inscription")) {//inscription en Base

                    String login = request.getParameter("login");
                    System.out.println(login);

                    boolean bol = connect.userExiste(login);
                    System.out.println(bol);
                    if (bol) {

                        out.print("utilisateur deja existant");
                    } else {
                        out.print("bienvenue " + login);
                    }

                } else if (formulaire_origine.equals("connexion")) { // connexion de l'utilisateur
                    String login = request.getParameter("Login_connexion");
                    String mdp = request.getParameter("mdp_connexion");
                    if (connect.connexionUserBDD(login, mdp)) {
                        out.print("connexion utilisateur réussi");
                    } else {
                        out.print("Login/mot de passe incorrect");
                    }
                } else {
                    out.print("variable passer:" + formulaire_origine);
                }
//             state.close();
//             conn.close();
            } catch (Exception ex) {
                out.print("erreur enregistrement");
                ex.printStackTrace();
            } finally {
                if (connect != null) {
                    // closes the database connection
                try {
                    connect.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                }
            }
        }
    }
}

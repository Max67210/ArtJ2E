
import ges_bdd.Connexion;
import java.io.*;
import java.sql.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ArtServlet extends HttpServlet {

    public static ArrayList<String> listNomsImagesDownload = new ArrayList<String>();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        if (ServletFileUpload.isMultipartContent(request)) {

            out.println("dans upload");
            String UPLOAD_DIRECTORY = "pictures";
            out.println(UPLOAD_DIRECTORY + "\n");

            // configuration de l'upload
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // met une localisation temporaire
            factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

            ServletFileUpload upload = new ServletFileUpload(factory);

            // ou est mis le fichier
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
                    String fileName="";
                    String titre="";
                    String cate = "";
                    String hidden ="";
                    
                    String cat="";
                    // iterates over form's fields
                    out.println("dans le if item\n");
                    for (FileItem item : formItems) { // 1 => file 2=> titre 3=> catergorie 4=> hidden
                        // processes only fields that are not form fields
                        if (!item.isFormField()) {
                            fileName = new File(item.getName()).getName();
                            String filePath = uploadPath + File.separator + fileName;
                            out.println(filePath + "\n");
                            out.println(fileName);
                            
                            File storeFile = new File(filePath);
                           
                            // saves the file on disk
                            item.write(storeFile);

                        }else{
                            if("nomImage".equals(item.getFieldName())){
                                titre = item.getString();
                            }else if("categorie".equals(item.getFieldName())){
                                cate = item.getString();
                            }else if("div_type_form".equals(item.getFieldName())){
                                hidden = item.getString();
                            }
                        }
                        
                    }
                    out.println("titre "+titre);
                    out.println("cat "+cate);
                    out.println("hid "+hidden);
                    Connexion connect = new Connexion(); // instanciation et ouverture de la base de donnée.
                    String depositaire ="";
                    if(session.getAttribute("loginUser")!=null && !"".equals(session.getAttribute("loginUser").toString())){
                        depositaire =session.getAttribute("loginUser").toString();
                    }else{
                        depositaire="inconnu";
                    }
                    connect.ajouterRessource(titre,cate, fileName,depositaire);
                    response.sendRedirect("/ArtJ2E/acceuil.jsp");
                }
            } catch (Exception ex) {
                System.out.println("erreur upload");
            }
        } else {// Fin traitement multi part.
            response.setContentType("text/html");
            Connexion connect = new Connexion(); // instanciation et ouverture de la base de donnée.
            String formulaire_origine = request.getParameter("div_type_form");
//            HttpSession session = request.getSession();
//        out.print(formulaire_origine);
            try {

                //inscription en Base ***********************************************
                if (formulaire_origine.equals("inscription")) {

                    String login = request.getParameter("login");
                    String mdp = this.hachage(request.getParameter("pass"));
//                    System.out.println(login);

                    boolean bol = connect.userExiste(login);
//                    System.out.println(bol);
                    if (bol) {
                        out.print("utilisateur deja existant");
                    } else {
                        connect.inscriptionUserBDD(login, mdp);
                        session.setAttribute("loginUser", login);
                        out.print("Connecté en tant que: " + session.getAttribute("loginUser"));
                    }

                } // connexion de l'utilisateur ***********************************************
                else if (formulaire_origine.equals("connexion")) {
                    boolean authenOk = connect.connexionUserBDD(request.getParameter("login"), this.hachage(request.getParameter("pass")));
                    if (authenOk) {
                        session.setAttribute("loginUser", request.getParameter("login"));
                        out.print("Connecté en tant que: " + session.getAttribute("loginUser"));

                    } else {
                        out.print("Login/mot de passe incorrect");
                    }
                } else if (formulaire_origine.equals("EnregistrementPanier")) {
                    String str = "";
//                    try {
                        String[] choix = request.getParameterValues("ImagesSelect");
                        for (int i = 0; i < choix.length; ++i) {
                            listNomsImagesDownload.add(choix[i]);
                        }
                        String html="";
                         for (int i = 0; i < listNomsImagesDownload.size();i++) {
                             html += listNomsImagesDownload.get(i);
                         }
                         out.print(html);
//                        session.setAttribute("listNomsImagesDownload", listNomsImagesDownload);
//                        response.sendRedirect("/ArtJ2E/acceuil.jsp"); 
                        
//                        } else {
//                            str = " <TABLE BORDER=\"1\">"
//                                    + " <CAPTION> Votre panier </CAPTION>"
//                                    + " <TR>"
//                                    + " <TH> Numero </TH>"
//                                    + " <TH> Nom Image </TH>"
//                                    + " <TH> Supprimer </TH>"
//                                    + " </TR>";
//                            int i = 0;
//                            String html = "";
//                            for (String imageSelect : listNomsImagesDownload) {
//                                str += "<TR>"
//                                        + "<TD>" + i + "</TD>"
//                                        + "<TD>" + imageSelect + "</TD>"
//                                        + "<TD> <input type='checkbox' name='panier' value='" + imageSelect + "'>" + imageSelect + " </TD>"
//                                        + "</TR>";
//                                i++;
//                            }
//                            str += "</br></br><input type=\"submit\" value=\"Supprimer Images Selectionnées\" />"
//                                    + "<input type=\"submit\" value=\"Telecharger au format Zip\" />";
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    } finally {
//                        out.print(str);
//                    }
                } else if (formulaire_origine.equals("rechercheCategor")) {
                    connect.RecupImageParCategorie(request.getParameter("categor"));
                    String htmlOut = "<h1>Bienvenue sur ArtJ2E!</h1></br></br>";
                    for (images.Images uneImage : Connexion.listImagesCateg)
                    {
                        htmlOut += "<form id='formulaire_connexion' action='servlet/ArtServlet' method='post'>"
                         +"<input type='checkbox' name='ImagesSelect' value="+uneImage.getTitre()+">"+uneImage.getTitre()+"<br>"
                         +"<img src=\"pictures/"+uneImage.getUrlImg()+"\" alt=\""+uneImage.getTitre()+"\" title=\""+uneImage.getTitre()+"\">"
                         +"<p>ajouter par "+uneImage.getDepositeur()+" déposé le "+uneImage.getDate()+" ayant pour titre "+uneImage.getTitre()+" (cat:"+uneImage.getCategorie()+")</p></br>";
                    }
            htmlOut += "<input type='hidden' name=\"div_type_form\" value=\"EnregistrementPanier\"/>"
                    + "<input type='submit' value='Enregistrer les images selectionnées'/>"
                    + "</form>";
                out.println(htmlOut);
                Connexion.listImagesCateg.clear();
                    
                }
                else {
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

    public String hachage(String unMdp) {
        StringBuffer hexString = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(unMdp.getBytes());

            byte byteData[] = md.digest();

            //convert the byte to hex format method 1
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }

            //convert the byte to hex format method 2
            for (int i = 0; i < byteData.length; i++) {
                String hex = Integer.toHexString(0xff & byteData[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Erreur dans le achage du mot de passe");
        } finally {
            return hexString.toString();
        }
    }
}

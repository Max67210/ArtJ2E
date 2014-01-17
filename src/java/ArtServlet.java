
import ges_bdd.Connexion;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ArtServlet extends HttpServlet {


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        Connexion connect = new Connexion(); // instanciation et ouverture de la base de donnée.
        
        
        String formulaire_origine = request.getParameter("div_type_form");
//        out.print(formulaire_origine);
        
        try {
            if (formulaire_origine.equals("inscription")) {//inscription en Base
                
                String login = request.getParameter("login");
                System.out.println(login);
                
                boolean bol =  connect.userExiste(login);
                System.out.println(bol);
                if(bol){
                    
                    out.print("utilisateur deja existant");
                }else{
                    out.print("bienvenue "+login);
                }
                
            } else if (formulaire_origine.equals("connexion")) { // connexion de l'utilisateur
                String login = request.getParameter("Login_connexion");
                String mdp = request.getParameter("mdp_connexion");
                if (connect.connexionUserBDD(login, mdp)) {
                    out.print("connexion utilisateur réussi");
                }
                else {
                    out.print("Login/mot de passe incorrect");
                }

            } else if (formulaire_origine.equals("ajout_image")) {
                System.out.println("test");
                connect.ajouterRessource("test", "cat");
                //InputStream inputStream = null;

                // obtains the upload file part in this multipart request
                Part filePart = request.getPart("file");
                String nomImage = request.getParameter("nomImage");
                String nomCateg = request.getParameter("categorie");
                // à tester
                out.print(nomImage);
                out.print(nomCateg);
                String format = "yyyy-MM-dd"; 

                java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
                java.util.Date date = new java.util.Date(); 
                if (filePart != null) {
                    
                    
                    // prints out some information for debugging
                    System.out.println(filePart.getName());
                    System.out.println(filePart.getSize());
                    System.out.println(filePart.getContentType());

                    // obtains input stream of the upload file
                    //inputStream = filePart.getInputStream();
                    
           
                    connect.ajouterRessource(nomImage, nomCateg);
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
//                try {
//                    connect.close();
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                }
            }
        }
    }
}

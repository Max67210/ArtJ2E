
import ges_bdd.Connexion;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import ges_bdd.uneConnexion;

public class ArtServlet extends HttpServlet {


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        Connexion connect = new Connexion(); // instanciation et ouverture de la base de donnée.
        
        
        String formulaire_origine = request.getParameter("div_type_form");
        try {
            if (formulaire_origine.equals("inscription")) {//inscription en Base

                String nom = request.getParameter("Login_insc");
                String pass = request.getParameter("mdp_insc");
                connect.inscriptionUserBDD(nom, pass);
                
            } else if (formulaire_origine.equals("connexion")) { // connexion de l'utilisateur
                out.print("connexion");

            } else if (formulaire_origine.equals("ajout_image")) {
                InputStream inputStream = null;

                // obtains the upload file part in this multipart request
                Part filePart = request.getPart("file");
                if (filePart != null) {
                    
                    
                    
                    // prints out some information for debugging
                    System.out.println(filePart.getName());
                    System.out.println(filePart.getSize());
                    System.out.println(filePart.getContentType());

                    // obtains input stream of the upload file
                    inputStream = filePart.getInputStream();
           
                    connect.ajouterRessource("test", "cat");
                }
            } else {
                out.print("variable passer:" + formulaire_origine);
            }
//             state.close();
//             conn.close();
        } catch (Exception ex) {                                // erreur avec la base de donnée
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

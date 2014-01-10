
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import ges_bdd.uneConnexion;

public class ArtServlet extends HttpServlet {

    private Connection conn;
    private Statement state = null;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //uneConnexion.getInstance();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String formulaire_origine = request.getParameter("div_type_form");
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/artj2e", "root", "");      // Connexion a la BDD:
//            state = conn.createStatement();         //Création d'un objet Statement

            if (formulaire_origine.equals("inscription")) {//inscription en Base
                String insert = "";
                String nom = request.getParameter("Login_insc");
                String pass = request.getParameter("mdp_insc");
//                out.print(nom);
//                out.print(pass);
                out.print(conn);

//                insert ="INSERT INTO `user`(`userName`, `userPass`) VALUES ('"+nom+"','"+pass+"')";
//                state.executeUpdate(insert);
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
                    // constructs SQL statement
                    String sql = "INSERT INTO ressources (titre, categorie) values (?, ?)";
                    PreparedStatement statement = conn.prepareStatement(sql);
                    statement.setString(1, "test");
                    statement.setString(2, "cat");

                    /*if (inputStream != null) {
                        // fetches input stream of the upload file for the blob column
                        statement.setBlob(3, inputStream);
                    }
*/
                    // sends the statement to the database server
                    statement.executeUpdate();
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
            if (conn != null) {
                // closes the database connection
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}

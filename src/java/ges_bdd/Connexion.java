/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ges_bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Mexios
 */
public class Connexion {

    private Connection conn;
    private Statement state = null;

    public Connexion() {
        try {
            conn = uneConnexion.getInstance();
            state = conn.createStatement();         //Création d'un objet Statement
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void close() throws SQLException {
        conn.close();
    }

    public void AjouterRessource(String unTitre, String uneCategorie) {
        try {
            String sql = "INSERT INTO ressources (titre, categorie) values (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, unTitre);
            statement.setString(2, uneCategorie);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

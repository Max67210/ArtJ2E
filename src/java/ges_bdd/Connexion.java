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
    private String requete;

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

    public void ajouterRessource(String unTitre, String uneCategorie) {
        try {
            requete = "INSERT INTO ressources (titre, categorie) values (?, ?)";
            PreparedStatement statement = conn.prepareStatement(requete);
            statement.setString(1, unTitre);
            statement.setString(2, uneCategorie);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void inscriptionUserBDD (String unLogin, String unPassword) {
        try {
            System.out.println("ici");
            requete = "INSERT INTO `user`(`userName`, `userPass`) VALUES ('"+unLogin+"','"+unPassword+"')";
            PreparedStatement statement = conn.prepareStatement(requete);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

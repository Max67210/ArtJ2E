/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ges_bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    private PreparedStatement statement;
    private ResultSet rs;
    private boolean btrouver =false;

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
            requete = "INSERT INTO `ressources` (`titre`, `categorie`) VALUES ('"+unTitre+"','"+uneCategorie+"')";
            statement = conn.prepareStatement(requete);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void inscriptionUserBDD (String unLogin, String unPassword) {
        try {
            requete = "INSERT INTO `user`(`userName`, `userPass`) VALUES ('"+unLogin+"','"+unPassword+"')";
            statement = conn.prepareStatement(requete);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean connexionUserBDD (String unLogin, String unPassword) {
        try {
            requete = "SELECT * FROM `user` WHERE userName='"+unLogin+"' AND userPass='"+unPassword+"'";
            statement = conn.prepareStatement(requete);
            rs = statement.executeQuery();
            if (rs != null) {
                btrouver = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            return btrouver;
        }
    }
    
    public boolean userExiste(String unLogin){
        boolean existe = false;
         try {
            requete = "SELECT COUNT(*) FROM `user` WHERE userName='"+unLogin+"'";
            statement = conn.prepareStatement(requete);
            rs = statement.executeQuery();
            if (rs.next()) {
                int count =rs.getInt(1);
                if(count > 0){
                    existe = true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            return existe;
        }
    }
}

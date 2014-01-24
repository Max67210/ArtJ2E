/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ges_bdd;

import images.Images;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    public static ArrayList<Images> listImagesCateg =  new ArrayList<Images>();

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

    public void ajouterRessource(String unTitre, String uneCategorie, String url, String deposit) {
        try {
            requete = "INSERT INTO `ressources` (`titre`, `categorie`, `url_img`, `depositeur`) VALUES ('"+unTitre+"','"+uneCategorie+"','"+uneCategorie+"')";
            statement = conn.prepareStatement(requete);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<String> getLastRessources(){
        ArrayList<String> array= new ArrayList<String>();
        try {
            requete = "Select * from `ressources` ORDER BY id DESC LIMIT 1";
            statement = conn.prepareStatement(requete);
            rs = statement.executeQuery();
            if (rs.next()) {
                array.add(rs.getString("id"));
                array.add(rs.getString("titre"));
                array.add(rs.getString("date"));
                array.add(rs.getString("categorie"));
                array.add(rs.getString("url_img"));
                array.add(rs.getString("depositeur"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            return array;
        }
    }
    
    public ArrayList<String> getListCategories(){
        ArrayList<String> array= new ArrayList<String>();
        try {
            requete = "Select categorie from `ressources` GROUP BY categorie";
            statement = conn.prepareStatement(requete);
            rs = statement.executeQuery();
            while (rs.next()) {
                array.add(rs.getString("categorie"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            return array;
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
    
    public void RecupImageParCategorie (String uneCategorie)  {
            try {
                requete = "SELECT * FROM `ressources` WHERE categorie='"+uneCategorie+"'";
                statement = conn.prepareStatement(requete);
                rs = statement.executeQuery();
                while (rs.next()) {
                    listImagesCateg.add(new Images(rs.getInt("id"),rs.getString("titre"), rs.getString("date"),rs.getString("categorie"), rs.getString("url_img"), rs.getString("depositeur")));
                }
            } catch (SQLException ex) {
                ex.printStackTrace(); 
            }
    }
}

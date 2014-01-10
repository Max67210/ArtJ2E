package ges_bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Aurora - MESSMER VALENTIN
 * 
 */
public class uneConnexion{
    
    //url de connexion à la base de donnée
    private  final String url_BDD = "jdbc:mysql://localhost:3306/artj2e";
    
    //nom de l'utilisateur de la base de donnée
    private  final String user_BDD = "root";
    
    //mot de passe pour le connexion BDD
    private  final String pass_BDD = "";
    
    //Objet de connexion
    private static Connection connect = null;
    
    //constructeur privé
    private uneConnexion(){
        try {           
            connect = DriverManager.getConnection(this.url_BDD, this.user_BDD, this.pass_BDD);
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
    }
    // Méthode qui retourne l'instance et crée une connexion si elle n'existe pas.
    public static Connection getInstance(){
        if(connect == null){
            new uneConnexion();
//            System.out.println("Instanciation de la connexion avec la base SQL ...");
        }else{
//            System.out.println("Connexion Sql déjà existante");
        }
        return connect;
    }
}

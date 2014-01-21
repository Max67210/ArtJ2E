/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag;

import ges_bdd.Connexion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Aurora
 */
public class LastPictureAdded extends SimpleTagSupport {

    String htmlOut = "";

    @Override
    public void doTag() throws JspException {
        try {
            JspWriter out = getJspContext().getOut();
            
            Connexion connect = new Connexion(); // instanciation et ouverture de la base de donnée.
            
            ArrayList<String> array = new ArrayList<String>();
            array = connect.getLastRessources();
            htmlOut = "<h1>Bienvenue sur ArtJ2E!<h1>"
                    + "<h2>Voici la dernière image ajouter sur le site</h2>"
                    + "<img src=\"pictures/"+array.get(4)+"\" alt=\""+array.get(1)+"\" title=\""+array.get(1)+"\">"
                    + "<p>ajouter par "+array.get(5)+" à le "+array.get(2)+" ayant pour titre "+array.get(1)+" (cat:"+array.get(3)+")</p>";
            //<img src=\"pictures/guerrier_1.jpg\" alt=\"dans le alt\" title=\"le titre\">
           
            out.println(htmlOut);
        } catch (IOException ex) {
            System.out.println("Erreur pour recherchee last picture");
        }
    }
}

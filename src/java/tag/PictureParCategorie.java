/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag;

import ges_bdd.Connexion;
import images.Images;
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
public class PictureParCategorie extends SimpleTagSupport {

    String htmlOut = "";

    @Override
    public void doTag() throws JspException {
        try {
            JspWriter out = getJspContext().getOut();
            
            Connexion connect = new Connexion(); // instanciation et ouverture de la base de donnée.
            connect.RecupImageParCategorie("elyarien");
            
            
            htmlOut = "<h1>Bienvenue sur ArtJ2E!</h1></br></br>";
            for (Images uneImage : Connexion.listImagesCateg) {
                
                htmlOut += "<form id='formulaire_connexion' action='servlet/ArtServlet' method='post'>"
                         +"<input type='checkbox' name='ImagesSelect' value="+uneImage.getTitre()+">"+uneImage.getTitre()+"<br>"
                         +"<img src=\"pictures/"+uneImage.getUrlImg()+"\" alt=\""+uneImage.getTitre()+"\" title=\""+uneImage.getTitre()+"\">"
                         +"<p>ajouter par "+uneImage.getDepositeur()+" déposé le "+uneImage.getDate()+" ayant pour titre "+uneImage.getTitre()+" (cat:"+uneImage.getCategorie()+")</p></br>";
            }
            htmlOut += "<input type='hidden' name=\"div_type_form\" value=\"EnregistrementPanier\"/>"
                    + "<input type='submit' value='Enregistrer les images selectionnées'/>"
                    + "</form>";
            out.println(htmlOut);
        } catch (IOException ex) {
            System.out.println("Erreur pour rechercher les images");
        }
    }
}

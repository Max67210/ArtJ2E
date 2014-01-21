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
public class GenreSelect extends SimpleTagSupport {

    private String genre;
    String htmlOut = "";

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        try {
            JspWriter out = getJspContext().getOut();
            Connexion connect = new Connexion(); // instanciation et ouverture de la base de donnée.
            ArrayList<String> array = new ArrayList<String>();
            array = connect.getListCategories();
            if ("select".equals(this.genre)) {
                htmlOut = "<ul>\n"
                        + "   <form action=\"servlet/resultat\" method=\"post\">\n"
                        + "     <select name=\"categorie\">\n";
                            for(int i = 0 ; i < array.size() ; i++){ // Listing de toutes les categorie
                              htmlOut+="<option value=\""+array.get(i)+"\">"+array.get(i)+"</option>";  
                            }
                
                htmlOut+= "  </select>\n"
                        + "   <input type=\"submit\" value=\"GO!\"/>\n"
                        + "  </form>\n"
                        + "</ul>";
                
            } else if ("check".equals(this.genre)) {
                htmlOut = "<ul>\n"
                        + "  <form action=\"servlet/resultat\" method=\"post\">\n";
                        for(int i = 0 ; i < array.size() ; i++){ // Listing de toutes les categorie
                            htmlOut+="<input type=\"radio\" name=\"categorie\" value=\""+array.get(i)+"\">"+array.get(i)+"<br>";
                          }
                htmlOut += "  </form>\n"
                        + "</ul>";
            } else {
                htmlOut = "pas de selection";
            }
            out.println(htmlOut);
        } catch (IOException ex) {
            Logger.getLogger(GenreSelect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}

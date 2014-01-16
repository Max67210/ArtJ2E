/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag;

import java.io.IOException;
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
public class genreSelect extends SimpleTagSupport {

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
            if ("select".equals(this.genre)) {
                htmlOut = "<ul>\n"
                        + "                <form action=\"servlet/resultat\" method=\"post\">\n"
                        + "                    <select name=\"categorie\">\n"
                        + "                        <option>Dark-Fantasy</option>\n"
                        + "                        <option>Humain</option>\n"
                        + "                        <option>Delorien</option>\n"
                        + "                        <option>Akwalien</option>\n"
                        + "                        <option>Elarien</option>\n"
                        + "                        <option>Paysage-Fantasy</option>\n"
                        + "                    </select>\n"
                        + "                    <input type=\"submit\" value=\"GO!\"/>\n"
                        + "                </form>\n"
                        + "            </ul>";
            } else if ("check".equals(this.genre)) {
                htmlOut = "<ul>\n"
                        + "                <form action=\"servlet/resultat\" method=\"post\">\n"
                        + "<input type=\"radio\" name=\"cat\" value=\"Dark-Fantasy\">Dark-Fantasy<br>\n"
                        + "<input type=\"radio\" name=\"cat\" value=\"Humain\">Humain<br>\n"
                        + "<input type=\"radio\" name=\"cat\" value=\"Delorien\">Delorien<br>\n"
                        + "<input type=\"radio\" name=\"cat\" value=\"Akwalien\">Akwalien<br>\n"
                        + "<input type=\"radio\" name=\"cat\" value=\"Elarien\">Elarien<br>\n"
                        + "<input type=\"radio\" name=\"cat\" value=\"Paysage-Fantasy\">Paysage-Fantasy<br>\n"
                        + "                </form>\n"
                        + "            </ul>";
            } else {
                htmlOut = "pas de selection";
            }
            out.println(htmlOut);
        } catch (IOException ex) {
            Logger.getLogger(genreSelect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}

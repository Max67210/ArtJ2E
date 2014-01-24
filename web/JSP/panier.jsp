<%-- 
    Document   : panier
    Created on : 24 janv. 2014, 15:12:57
    Author     : Mexios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
         if (ArtServlet.listNomsImagesDownload == null) {
             String str = "Votre panier est vide !";
         }
         else {
             %>
               <TABLE BORDER="1"> 
                  <CAPTION> Votre panier </CAPTION> 
                    <TR>
                        <TH> Numero </TH>
                        <TH> Nom Image </TH>
                        <TH> Supprimer </TH>
                    </TR>
                    <%
             int i = 0;
             String html= "";
             for (String imageSelect : ArtServlet.listNomsImagesDownload) {
            html += "<TR>"
                    + "<TD>" +i+"</TD>"
                    + "<TD>" +imageSelect+ "</TD>"
                    + "<TD> <input type='checkbox' name='panier' value='"+imageSelect+"'>"+imageSelect+"> </TD>+"
                    + "</TR>";
             }
             out.print(html);
             %>
             
        <input type="submit" value="Telecharger les images du panier"/>
         }
        %>
        
    </body>
</html>

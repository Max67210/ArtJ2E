
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ page import="java.util.List" %>
        <title>JSP Page</title>
    </head>
    <body>
        <div id="div_main">
        <% 
         ArrayList<Images> listPanier = new ArrayList<Images>();
         listPanier = (ArrayList) session.getAttribute("listNomsImagesDownload");
         if (listPanier == null) {
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
             for (String imageSelect : listPanier) {
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
        </div>
    </body>
</html>

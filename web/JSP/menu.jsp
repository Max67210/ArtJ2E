<%-- 
    Document   : menu
    Created on : 10 janv. 2014, 10:08:12
    Author     : Mexios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/navigation.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <!-- LA NAVIGATION -->
        <div id="div_navigation">
            <h3>Navigation</h3>
            <div class="separator_nav" ></div>
            <p> recherche une catégorie</p>
            <ul>
                <form action="servlet/resultat" method="post">
                    <select name="categorie">
                        <option>Dark-Fantasy</option>
                        <option>Humain</option>
                        <option>Delorien</option>
                        <option>Akwalien</option>
                        <option>Elarien</option>
                        <option>Paysage-Fantasy</option>
                    </select>
                    <input type="submit" value="GO!"/>
                </form>
            </ul>
            <div class="separator_nav" ></div>
            <ul>
                <li><a id="link_add_picture">Ajouter une image</a></li>
            </ul>
        </div>
    </body>
</html>

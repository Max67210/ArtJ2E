<%-- 
    Document   : menu
    Created on : 10 janv. 2014, 10:08:12
    Author     : Mexios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" uri="/WEB-INF/tlds/tabLib.tld" %>
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
            <tag:genreSelect genre="check"/>
            
            <div class="separator_nav" ></div>
            <ul>
                <li><a id="link_add_picture">Ajouter une image</a></li>
            </ul>
        </div>
    </body>
</html>

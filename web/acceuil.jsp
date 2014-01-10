<%-- 
    Document   : acceuil
    Created on : 24 déc. 2013, 13:59:02
    Author     : Aurora

    aide:
    http://www.mistra.fr/tutoriel-jee-application-web-hello-world/tutoriel-jee-servlets-jsp.html
http://www.tutorialspoint.com/jsp/jsp_file_uploading.htm
http://inserthtml.developpez.com/tutoriels/css/galerie-images-css3-avec-effet-zoom/
http://www.codejava.net/coding/upload-files-to-database-servlet-jsp-mysql


--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <link rel="stylesheet" type="text/css" href="css/css_acceuil.css">
        <link rel="stylesheet" type="text/css" href="css/header.css">
        <link rel="stylesheet" type="text/css" href="css/navigation.css">
        <link rel="stylesheet" type="text/css" href="css/footer.css">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

        <!-- Inclusion page header.jsp --!>
        <jsp:directive.include file="/JSP/header.jsp"/>
        
        <!-- Inclusion page menu.jsp --!>
        <jsp:directive.include file="/JSP/menu.jsp"/>
        
        <!-- Inclusion page contenu.jsp --!>
        <jsp:directive.include file="/JSP/contenu.jsp"/>

        <!-- Inclusion page footer.jsp --!>
        <jsp:directive.include file="/JSP/footer.jsp"/>
       
        <!-- Inclusion page connexion.jsp --!>
        <jsp:directive.include file="/JSP/connexion.jsp"/>
        
        <!-- Inclusion page inscription.jsp --!>
        <jsp:directive.include file="/JSP/inscription.jsp"/>

        <!-- Inclusion page ajoutImage.jsp --!>
        <jsp:directive.include file="/JSP/ajoutImage.jsp"/>

        
    </body>
</html>


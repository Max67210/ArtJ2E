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
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script type="text/javascript" src="JS/acceuil.js"></script>

        <!-- Inclusion page Header.jsp --!>
        <jsp:directive.include file="/JSP/Header.jsp"/>
        
        <!-- Inclusion page Menu.jsp --!>
        <jsp:directive.include file="/JSP/Menu.jsp"/>
        
        <!-- Inclusion page Contenu.jsp --!>
        <jsp:directive.include file="/JSP/Contenu.jsp"/>

        <!-- Inclusion page Footer.jsp --!>
        <jsp:directive.include file="/JSP/Footer.jsp"/>
       
        <!-- Inclusion page Connexion.jsp --!>
        <jsp:directive.include file="/JSP/Connexion.jsp"/>
        
        <!-- Inclusion page Inscription.jsp --!>
        <jsp:directive.include file="/JSP/Inscription.jsp"/>

        <!-- Inclusion page AjoutImage.jsp --!>
        <jsp:directive.include file="/JSP/AjoutImage.jsp"/>

        
    </body>
</html>


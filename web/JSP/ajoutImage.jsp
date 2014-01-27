<%-- 
    Document   : AjoutImage
    Created on : 10 janv. 2014, 13:24:19
    Author     : Mexios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" uri="/WEB-INF/tlds/tabLib.tld" %>
<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="css/ajoutImage.css">
<script type="text/javascript" src="JS/ajout_image.js"></script>
<!-- Ajout d'image -->
<div id="div_form_ajout_image" class="non_active_inscripton">
    <div id="div_img_ajout"><img id="img_insc_ajout" src="pictures/exit.png" /></div>
    <h3>DDL Image</h3>
    Selection de l'image à ajouter <br />
    <form action="servlet/ArtServlet" method="post" enctype="multipart/form-data">
        <input type="file" name="file" />
        <br />
        Nom de l'image : <input type="text" id="nomImage" name="nomImage"/> <br/>
        <tag:genreSelect genre="selectAddImg" />
        <input type="hidden" name="div_type_form" value="ajout_image">
        <input type="submit" value="Ajouter" />
    </form>
</div>

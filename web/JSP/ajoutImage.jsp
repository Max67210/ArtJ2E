<%-- 
    Document   : AjoutImage
    Created on : 10 janv. 2014, 13:24:19
    Author     : Mexios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript" src="JS/ajout_image.js"></script>
<!-- Ajout d'image -->
<div id="div_form_ajout_image" class="non_active_inscripton">
    <div id="div_img_ajout"><img id="img_insc_ajout" src="pictures/exit.png" /></div>
    <h3>DDL Image</h3>
    Selection de l'image à ajouter <br />
    <form action="servlet/ArtServlet" method="post">
        <input type="file" name="file" />
        <br />
        Nom de l'image : <input type="text" name="nomImage"/> <br/>
        <select name="categorie">
            <option>Dark-Fantasy</option>
            <option>Humain</option>
            <option>Delorien</option>
            <option>Akwalien</option>
            <option>Elarien</option>
            <option>Paysage-Fantasy</option>
        </select>
        <input type="hidden" name="div_type_form" value="ajout_image">
        <input type="submit" value="Ajouter" />
    </form>
</div>

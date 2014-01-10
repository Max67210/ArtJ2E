<%-- 
    Document   : Inscription
    Created on : 10 janv. 2014, 13:22:49
    Author     : Mexios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<script type="text/javascript" src="JS/inscription.js"></script>
<!-- L'INSCRIPTION -->
<div id="div_form_inscription" class="non_active_inscripton">
    <div id="_insc"><img id="img_insc" src="pictures/exit.png" /></div>
    <form id="formulaire_insc" action="servlet/ArtServlet" method="post">
        <table>
            <tr>
                <td><label for="Login_insc">Pseudo:</label></td>
                <td><input type="text" id="Login_insc" name="Login_insc" placeholder="entrez votre Login"/></td>
            </tr>
            <tr>
                <td> <label for="mdp_insc">mot de passe:</label></td>
                <td><input type="password" id="mdp_insc" name="mdp_insc" placeholder="entrez votre mot de passe"/></td>
            </tr>
            <tr>
                <td> <label for="mdp_conf">Confirmation du mot de passe:</label></td>
                <td><input type="password" id="mdp_conf" name="mdp_conf" placeholder="Confirmation de votre mot de passe"/></td>
            </tr>
        </table>
        </br>
        <input type="hidden" name="div_type_form" value="inscription">
        <input id="btn_submit" type="submit" value="Merci de remplir les champs" disabled/>
    </form>
</div>

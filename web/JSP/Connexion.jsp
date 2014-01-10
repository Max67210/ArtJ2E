<%-- 
    Document   : Connexion
    Created on : 10 janv. 2014, 13:21:22
    Author     : Mexios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="JS/Connexion.js"></script>
    </head>
    <body>
        <!-- LA CONNEXION -->
        <div id="div_form_connexion" class="non_active_connexion">
            <div id="div_img"><img id="img_exit_co" src="pictures/exit.png" /></div>
            <form id="formulaire_connexion" action="servlet/ArtServlet" method="post">
                <table>
                    <tr>
                        <td><label for="Login_connexion">Pseudo:</label></td>
                        <td><input type="text" id="Login_connexion" name="Login_connexion" placeholder="entrez votre Login"/></td>
                    </tr>
                    <tr>
                        <td> <label for="mdp_connexion">mot de passe:</label></td>
                        <td><input type="password" id="mdp_connexion" name="mdp_connexion" placeholder="entrez votre mot de passe"/></td>
                    </tr>
                </table>
                </br>
                <input type="hidden" name="div_type_form" value="connexion">
                <input type="submit" value="connexion"/>
            </form>
        </div>
    </body>
</html>

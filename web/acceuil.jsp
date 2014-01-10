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
        <link rel="stylesheet" type="text/css" href="css/footer.css">
        <link rel="stylesheet" type="text/css" href="css/header.css">
        <link rel="stylesheet" type="text/css" href="css/navigation.css">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script type="text/javascript" src="JS/acceuil.js"></script>

        <!-- Inclusion page Header.jsp --!>
        <jsp:directive.include file="/JSP/Header.jsp"/>
        
        <!-- Inclusion page Menu.jsp --!>
        <jsp:directive.include file="/JSP/Menu.jsp"/>
        
                <!-- Inclusion page Contenu.jsp --!>
        <jsp:directive.include file="/JSP/Contenu.jsp"/>
       
        <!-- LE FOOTER -->
        <div id="footer_acceuil">
            <p>Ce site d'entrainement à la programmation JSP,SERVLET,HTML,CSS,JS,...  </br> par Messmer valentin  et Lefort Maxime </br> les images presentes sur le sites sont des images internet et HOK.</p>
        </div>

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

        <!-- Ajout d'image -->
        <div id="div_form_ajout_image" class="non_active_inscripton">
            <div id="div_img_ajout"><img id="img_insc_ajout" src="pictures/exit.png" /></div>
            <h3>DDL Image</h3>
            Selection de l'image à ajouter <br />
            <form action="servlet/Register" method="post" enctype="multipart/form-data">
                <input type="file" name="file" />
                <br />
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
    </body>
</html>


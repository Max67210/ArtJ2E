<%-- 
    Document   : header
    Created on : 10 janv. 2014, 10:13:41
    Author     : Mexios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="css/header.css">
<script type="text/javascript" src="JS/panier.js"></script>
<!-- LE HEADER -->
<div id="div_head_general">
    <ul>
        <%
            if (session.getAttribute("loginUser") != null && !"".equals(session.getAttribute("loginUser").toString())) {
                %>
                <p><% out.print("Connecté en tant que: "+session.getAttribute("loginUser").toString());%></p>
                <%
            }else{
                %>
                <li><a id="link_connexion">Login</a></li>
        <li><a id="link_enregistrement">Enregistrement</a></li>
        <li><a id="link_panier">Panier</a></li>
                <%
            }
            %>
    </ul>
</div>


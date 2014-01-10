$(document).ready(function() {

//alert("acceuil JS")
    /****************************************************/
    /**************** GESTION connexion *****************/
    /****************************************************/

    $("#link_connexion").click(function() {
        $("#div_form_connexion").css("z-index", "3");
    });

    $("#img_exit_co").click(function() {
        $("#div_form_connexion").css("z-index", "-3");
        $("#Login").val('');
        $("#mdp").val('');
    });
});
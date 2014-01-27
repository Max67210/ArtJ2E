$(document).ready(function() {

//alert("acceuil JS")
    /****************************************************/
    /**************** GESTION connexion *****************/
    /****************************************************/

    $("#link_connexion").click(function() {
        $("#div_form_connexion").css("z-index", "3");
        $("#div_form_inscription").css("z-index", "-3");
        $("#Login_connexion").val('');
        $("#mdp_connexion").val('');
        $("#Login_insc").val('');
        $("#mdp_insc").val('');
        $("#error_conn").empty();
    });

    $("#img_exit_co").click(function() {
        $("#div_form_connexion").css("z-index", "-3");
        $("#Login_connexion").val('');
        $("#mdp_connexion").val('');
        $("#Login_insc").val('');
        $("#mdp_insc").val('');
        $("#error_conn").empty();
    });
    
    $('#btn_submit_conn').on('click', function() {
//        alert($("#mdp_connexion").val());
        $.ajax({
            type: "POST",
            url: "servlet/ArtServlet",
            data: {
                login: $("#Login_connexion").val(),
                pass: $("#mdp_connexion").val(),
                div_type_form: "connexion"
            },
            success: function(data)
            {
                alert(data);
                if(data.startsWith("Connecté")){;
                    $("#div_form_connexion").css("z-index", "-3");
                    $("#div_head_general").html("<p>"+data+"</p>");
                }else{
                    $("#error_conn").text(data);
                }
            }
        });
        return false;
    });
});
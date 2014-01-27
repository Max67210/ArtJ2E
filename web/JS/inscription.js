$(document).ready(function() {

    /****************************************************/
    /*************** GESTION INSCRIPTION ****************/
    /****************************************************/

    $("#link_enregistrement").click(function() {
        $("#div_form_inscription").css("z-index", "3");
        $("#div_form_connexion").css("z-index", "-3");
        $("#Login_insc").val('');
        $("#mdp_insc").val('');
        $("#Login_connexion").val('');
        $("#mdp_connexion").val('');
    });

    $("#img_insc").click(function() {
        $("#div_form_inscription").css("z-index", "-3");
        $("#Login_insc").val('');
        $("#mdp_insc").val('');
        $("#Login_connexion").val('');
        $("#mdp_connexion").val('');
    });


    // verification du mdp
    mpd_identique = false;
    $("#mdp_insc").keyup(function() {
        mpd_identique = false;
        // si j'ai le confirm deja remplis
        if ($("#mdp_conf").val() != "")
        {
            //je fait la verif
            if ($(this).val() == $("#mdp_conf").val())
            {
                $("#mdp_conf").css("border", "2px solid green");
                mpd_identique = true;
            }
            else
            {
                $("#mdp_conf").css("border", "2px solid red");
            }
        }
        gestionBouton();
    });

    $("#mdp_conf").keyup(function() {
        mpd_identique = false;
        // si j'ai le confirm deja remplis
        if ($("#mdp_conf").val() != "")
        {
            //je fait la verif
            if ($(this).val() == $("#mdp_insc").val())
            {
                $("#mdp_conf").css("border", "2px solid green");
                mpd_identique = true;
            }
            else
            {
                $("#mdp_conf").css("border", "2px solid red");
            }
        }
        gestionBouton();
    });

    var gestionBouton = function()
    {
        //alert(Login_dispo+" "+mpd_identique+" "+race_selection+" "+mail_OK);
        if (mpd_identique)
        {
            $("#btn_submit").removeAttr("disabled");
            $("#btn_submit").attr('value', 'Valider');
        }
        else
        {
            $("#btn_submit").attr("disabled", "disabled");
            $("#btn_submit").attr('value', 'Merci de remplir les champs');
        }
    };
    $('#btn_submit').on('click', function() {
//        alert('ddz');
        $.ajax({
            type: "POST",
            url: "servlet/ArtServlet",
            data: {
                login: $("#Login_insc").val(),
                pass: $("#mdp_insc").val(),
                div_type_form: "inscription"
            },
            success: function(data)
            {
                if(data.startsWith("Connecté")){
//                    alert("Bienvenue parmis nous "+ data+"!");
                    $("#div_form_inscription").css("z-index", "-3");
                    $("#div_head_general").html("<p>"+data+"</p>");
                }else{
                    $("#error_insc").text(data);
                }
            }
        });
        return false;
    });
    
    String.prototype.startsWith = function(prefix) {
        return this.indexOf(prefix) === 0;
    }

});
  
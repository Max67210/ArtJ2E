$(document).ready(function(){

//alert("acceuil JS")
/****************************************************/
/**************** GESTION connexion *****************/
/****************************************************/

        $("#link_connexion").click(function(){
            $("#div_form_connexion").css("z-index","3");
        });

        $("#img_exit_co").click(function(){
            $("#div_form_connexion").css("z-index","-3");
            $("#Login").val('');
            $("#mdp").val('');
        });
        
        

/****************************************************/
/*************** GESTION INSCRIPTION ****************/
/****************************************************/

    $("#link_enregistrement").click(function(){
            $("#div_form_inscription").css("z-index","3");
        });

        $("#img_insc").click(function(){
            $("#div_form_inscription").css("z-index","-3");
            $("#Login_insc").val('');
            $("#password").val('');
        });
        
        
    // verification du mdp
    mpd_identique = false;
  $("#mdp_insc").keyup(function(){
    mpd_identique = false;
  // si j'ai le confirm deja remplis
        if($("#mdp_conf").val()!="")
        {
          //je fait la verif
           if($(this).val()==$("#mdp_conf").val())
           {
            $("#mdp_conf").css("border","2px solid green");
            mpd_identique = true; 
           }
           else
           {
            $("#mdp_conf").css("border","2px solid red");
           }
        }
      gestionBouton()
    });
    
     $("#mdp_conf").keyup(function(){
    mpd_identique = false;
  // si j'ai le confirm deja remplis
        if($("#mdp_conf").val()!="")
        {
          //je fait la verif
           if($(this).val()==$("#mdp_insc").val())
           {
            $("#mdp_conf").css("border","2px solid green");
              mpd_identique = true; 
           }
           else
           {
            $("#mdp_conf").css("border","2px solid red");
           }
        }
      gestionBouton()
    });
    
    var gestionBouton = function()
  {
    //alert(Login_dispo+" "+mpd_identique+" "+race_selection+" "+mail_OK);
    if(mpd_identique)
    {
       $("#btn_submit").removeAttr("disabled");
    }
    else
    {
      $("#btn_submit").attr("disabled", "disabled");
    }
  }
  
/****************************************************/
/*************** GESTION ajout image ****************/
/****************************************************/

 $("#link_add_picture").click(function(){
            $("#div_form_ajout_image").css("z-index","3");
        });

        $("#div_img_ajout").click(function(){
            $("#div_form_ajout_image").css("z-index","-3");
        });
});
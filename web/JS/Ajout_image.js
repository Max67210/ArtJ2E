$(document).ready(function() {
    
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
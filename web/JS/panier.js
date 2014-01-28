$(document).ready(function() {

    /****************************************************/
    /*************** GESTION Panier ****************/
    /****************************************************/
    
//     $("#link_panier").click(function() {
//         alert('Panier !!');
//    });
    
    $("#link_panier").click(function() {
        $("#div_form_inscription").css("z-index", "-3");
        $("#div_form_connexion").css("z-index", "-3");

        alert('Panier !!');
        $.ajax({
            type: "POST",
            url: "servlet/ArtServlet",
            data: {
                div_type_form: "panier"
            },
            success: function(data)
            {
                $("#div_main").empty();
                 $("#div_main").html(data);
            }
        });
        return false;
    });
});
  
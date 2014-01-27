$(document).ready(function() {
    
/****************************************************/
/*************** GESTION recherche image ************/
/****************************************************/
        
        
        $('#selectRechercheCat').change(function() {
//           alert(cat);
            $.ajax({
            type: "POST",
            url: "servlet/ArtServlet",
            data: {
                categor: $("#selectRechercheCat option:selected" ).text(),
                div_type_form: "rechercheCategor"
            },
            success: function(data)
            {
//                alert(data);
                  $('#div_main').text(data);
            }
        });
        return false;
    });
});



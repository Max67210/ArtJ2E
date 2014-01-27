$(document).ready(function() {
    
/****************************************************/
/*************** GESTION recherche image ************/
/****************************************************/
        
        $('#btn_rechercheImg').on('click', function() {
        alert($('input[name=categorie]:checked').val());
    });
     $('.rd_btn_rech').change(function() {
//           alert(cat);
            $.ajax({
            type: "POST",
            url: "servlet/ArtServlet",
            data: {
                categor: $('input[name=categorie]:checked').val(),
                div_type_form: "rechercheCategor"
            },
            success: function(data)
            {
//                alert(data);
                    $('#div_main').empty();
                  $('#div_main').html(data);
            }
        });
        return false;
    });
});
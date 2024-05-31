$(document).ready(function() {
    var tipoHoras = [];
    $.get("http://localhost:8080/tipo-hora/", function (data, status){
		tipoHoras = data;
        mostrarTipoHoras(tipoHoras);
    });
});

function mostrarTipoHoras(tipoHoras){
    if(tipoHoras.length > 0){
		var contenido = "";
        tipoHoras.forEach(hora => {
			contenido += "<tr><td>" + hora.tramo + "</td>";
        });
        $("#tbodyListado").html(contenido);
        
        $("#tbodyListado").show();
        $("#mensaje").hide();
    } else{
        $("#mensaje").show();
        $("#tbodyListado").hide();
    }
}
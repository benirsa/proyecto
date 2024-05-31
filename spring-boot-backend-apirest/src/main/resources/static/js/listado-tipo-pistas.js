$(document).ready(function() {
    var tipoPistas = [];
    $.get("http://localhost:8080/tipo-pista/", function (data, status){
		tipoPistas = data;
        mostrarTipoPistas(tipoPistas);
    });
});

function mostrarTipoPistas(tipoPistas){
    if(tipoPistas.length > 0){
		var contenido = "";
        tipoPistas.forEach(tipoPista => {
			contenido += "<tr><td>" + tipoPista.descripcion + "</td><td>" + tipoPista.precio + "</td>" + 
            "<td><button class='btn btn-danger btn-sm mx-2' onclick='eliminarTipoPista(" + tipoPista.id + ")'>Eliminar</button>" +
            "<button class='btn btn-primary btn-sm mx-2' onclick='modificarTipoPista(" + tipoPista.id + ")'>Modificar</button></td></tr>"
        });
		$("#tbodyListado").html(contenido);
        
        $("#tbodyListado").show();
        $("#mensaje").hide();
    } else{
        $("#mensaje").show();
        $("#tbodyListado").hide();
    }
}
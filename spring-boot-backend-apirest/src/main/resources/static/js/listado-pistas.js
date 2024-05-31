$(document).ready(function() {
    var pistas = [];
    $.get("http://localhost:8080/pistas/", function (data, status){
		pistas = data;
        mostrarPistas(pistas);
    });
});

function mostrarPistas(pistas){
    if(pistas.length > 0){
		var contenido = "";
        pistas.forEach(pista => {
			contenido += "<tr><td>" + pista.tipoPista.descripcion + "</td><td>" + pista.estado + "</td><td>" + (pista.techado? 'Si': 'No') + "</td>" + 
            "<td><button class='btn btn-danger btn-sm mx-2' onclick='eliminarPista(" + pista.id + ")'>Eliminar</button>" +
            "<button class='btn btn-primary btn-sm mx-2' onclick='modificarPista(" + pista.id + ")'>Modificar</button></td></tr>"
        });
        $("#tbodyListado").html(contenido);
        
        $("#tbodyListado").show();
        $("#mensaje").hide();
    } else{
        $("#mensaje").show();
        $("#tbodyListado").hide();
    }
}
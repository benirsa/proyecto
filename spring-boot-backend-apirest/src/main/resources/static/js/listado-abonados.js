$(document).ready(function() {
    var abonados = [];
    $.get("http://localhost:8080/abonados/", function (data, status){
        abonados = data;
        mostrarAbonados(abonados);
    });
});

function mostrarAbonados(abonados){
    if(abonados.length > 0){
		var contenido = "";
        abonados.forEach(abonado => {
			contenido += "<tr><td>" + abonado.nombre + "</td><td>" + abonado.apellido1 + "</td><td>" + abonado.apellido2 + "</td>" + 
            "<td>" + abonado.dni + "</td><td>" + abonado.fechaNacimiento + "</td><td>" + abonado.telefono + "</td><td>" + abonado.direccion + "</td>" +
            "<td><button class='btn btn-danger btn-sm mx-2' onclick='eliminarAbonado(" + abonado.id + ")'>Eliminar</button>" +
            "<button class='btn btn-primary btn-sm mx-2' onclick='modificarAbonado(" + abonado.id + ")'>Modificar</button></td></tr>";
        });
		$("#tbodyListado").html(contenido);
        
        $("table").show();
        $("#mensaje").hide();
    } else{
        $("#mensaje").show();
        $("#tbodyListado").hide();
    }
}
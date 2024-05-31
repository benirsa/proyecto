$(document).ready(function() {
    var trabajadores = [];
    $.get("http://localhost:8080/usuarios/", function (data, status){
		trabajadores = data;
        mostrarTrabajadores(trabajadores);
    });
});

function mostrarTrabajadores(trabajadores){
    if(trabajadores.length > 0){
		var contenido = "";
        trabajadores.forEach(trabajador => {
			contenido += "<tr><td>" + trabajador.nombre + "</td><td>" + trabajador.apellido1 + "</td><td>" + trabajador.apellido2 + "</td>" + 
            "<td>" + trabajador.dni + "</td><td>" + trabajador.fechaNacimiento + "</td><td>" + trabajador.telefono + "</td><td>" + trabajador.usuario + "</td><td>" + trabajador.contrasena + "</td>" +
            "<td><button class='btn btn-danger btn-sm mx-2' onclick='eliminarTrabajador(" + trabajador.id + ")'>Eliminar</button>" +
            "<button class='btn btn-primary btn-sm mx-2' onclick='modificarTrabajador(" + trabajador.id + ")'>Modificar</button></td></tr>" 
        });
		$("#tbodyListado").html(contenido);
        
        $("#tbodyListado").show();
        $("#mensaje").hide();
    } else{
        $("#mensaje").show();
        $("#tbodyListado").hide();
    }
}

function eliminarTrabajador(id){

}

function modificarTrabajador(id){
    
}
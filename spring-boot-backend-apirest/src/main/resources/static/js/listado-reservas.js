$(document).ready(function() {
    var reservas = [];
    $.get("http://localhost:8080/reservas/", function (data, status){
		reservas = data;
        mostrarReservas(reservas);
    });
});

function mostrarReservas(reservas){
    if(reservas.length > 0){
		var contenido = "";
        reservas.forEach(reserva => {
			contenido += "<tr><td>" + reserva.pista.tipoPista.descripcion + "</td><td>" + reserva.tipoHora.tramo + "</td><td>" + reserva.abonado.dni + "</td>" + 
            "<td>" + reserva.fechaReserva + "</td><td>" + reserva.precioReserva + "</td>" +
            "<td><button class='btn btn-danger btn-sm mx-2' onclick='eliminarReserva(" + reserva.id + ")'>Eliminar</button>" +
            "<button class='btn btn-primary btn-sm mx-2' onclick='modificarReserva(" + reserva.id + ")'>Modificar</button></td></tr>"
        });
		$("#tbodyListado").html(contenido);
        
        $("#tbodyListado").show();
        $("#mensaje").hide();
    } else{
        $("#mensaje").show();
        $("#tbodyListado").hide();
}
}
package com.polideportivo.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "reservas")
public class Reserva implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// id de la pista que se reserva
	@Column(name="tipo_pista")
	private Long pista;

	// tipo de hora
	@Column(name="tipo_hora")
	private Long tipoHora;

	@Column(name = "fecha_reserva")
	private Date fechaReserva;

	// id del abonado que realiza la reserva
	private Long idAbonado;

	// precio de la pista
	@Column(name="precio_reserva")
	private Long precioReserva;

	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTipoPista() {
		return pista;
	}

	public void setTipoPista(Long tipoPista) {
		this.pista = tipoPista;
	}

	public Long getTipoHora() {
		return tipoHora;
	}

	public void setTipoHora(Long tipoHora) {
		this.tipoHora = tipoHora;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Long getIdAbonado() {
		return idAbonado;
	}

	public void setIdAbonado(Long idAbonado) {
		this.idAbonado = idAbonado;
	}

	public Long getPrecioReserva() {
		return precioReserva;
	}

	public void setPrecioReserva(Long precioReserva) {
		this.precioReserva = precioReserva;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}

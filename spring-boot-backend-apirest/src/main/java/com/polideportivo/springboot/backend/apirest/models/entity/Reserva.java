package com.polideportivo.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "reservas")
public class Reserva implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9123359604411345146L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_pista")
	private Pista pista;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_tipo_hora")
	private TipoHora tipoHora;

	@Column(name = "fecha_reserva")
	private Date fechaReserva;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_abonado")
	private Abonado abonado;

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

	public Pista getTipoPista() {
		return pista;
	}

	public void setTipoPista(Pista tipoPista) {
		this.pista = tipoPista;
	}

	public TipoHora getTipoHora() {
		return tipoHora;
	}

	public void setTipoHora(TipoHora tipoHora) {
		this.tipoHora = tipoHora;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Abonado getIdAbonado() {
		return abonado;
	}

	public void setIdAbonado(Abonado idAbonado) {
		this.abonado = idAbonado;
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
}

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
@Table(name = "pistas")
public class Pista implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// tipo de pista
	@Column(name="tipo_pista")
	private Long tipoPista;

	// estado en el que se encuentra la pista
	private Long estado;

	private Boolean techado;

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
		return tipoPista;
	}

	public void setTipoPista(Long tipoPista) {
		this.tipoPista = tipoPista;
	}

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

	public Boolean getTechado() {
		return techado;
	}

	public void setTechado(Boolean techado) {
		this.techado = techado;
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

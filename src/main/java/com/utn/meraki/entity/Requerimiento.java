package com.utn.meraki.entity;

import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name = "requerimientos")

public class Requerimiento {
	
	//ATRIBUTOS
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String id;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "fecha_publicacion")
	private Date fechaPublicacion;
	
	@Column(name = "precio_a_pagar")
	private Float precioApagar;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "id_estado")
	private EstadoRequerimiento estadoRequerimiento;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_requerimiento")
	private List<Archivo> archivos = new ArrayList<>();
	
	//CONSTRUCTOR
	public Requerimiento() {
	}

	//GET AND SET
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public Float getPrecioApagar() {
		return precioApagar;
	}

	public void setPrecioApagar(Float precioApagar) {
		this.precioApagar = precioApagar;
	}

	public EstadoRequerimiento getEstadoRequerimiento() {
		return estadoRequerimiento;
	}

	public void setEstadoRequerimiento(EstadoRequerimiento estadoRequerimiento) {
		this.estadoRequerimiento = estadoRequerimiento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Archivo> getArchivos() {
		return archivos;
	}

	public void setArchivos(List<Archivo> archivos) {
		this.archivos = archivos;
	}
	
}

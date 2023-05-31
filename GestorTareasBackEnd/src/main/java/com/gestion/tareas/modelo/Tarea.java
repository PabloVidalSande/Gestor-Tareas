package com.gestion.tareas.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tareas")
public class Tarea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", length = 60, nullable = false)
	private String nombre;

	@Column(name = "asignado", length = 60)
	private String asignado;

	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "realizada")
	private Boolean realizada;
	

	public Tarea() {

	}

	public Tarea(Long id, String nombre, String asignado, String descripcion, Boolean realizada) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.asignado = asignado;
		this.descripcion = descripcion;
		this.realizada = realizada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAsignado() {
		return asignado;
	}

	public void setAsignado(String asignado) {
		this.asignado = asignado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Boolean getRealizada() {
		return realizada;
	}

	public void setRealizada(Boolean realizada) {
		this.realizada = realizada;
	}


}

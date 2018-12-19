package es.hubiqus.inventario.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="profesor")
public class Profesor {
//private static final String FORMAT_ES = "dd/MM/yyyy";
	
	private String id;
	private String nombre;
	private String apellido;
	private Date fecha;
	private Integer edad;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="codigo", unique=true)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
}

package es.hubiqus.inventario.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="alumno")
public class Alumno {
//private static final String FORMAT_ES = "dd/MM/yyyy";
	
	private Integer id;
	private String nombre;
	private String apellido;
	private Integer edad;
	private String sexo;
	private Date fecha;
	private Padre codigoPadre;
	private Profesor codigoProfesor;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="idalumno", unique=true)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@ManyToOne
	@JoinColumn(name="codigoPadre")
	public Padre getCodigoPadre() {
		return codigoPadre;
	}
	public void setCodigoPadre(Padre codigoPadre) {
		this.codigoPadre = codigoPadre;
	}
	
	@ManyToOne
	@JoinColumn(name="codigoProfesor")
	public Profesor getCodigoProfesor() {
		return codigoProfesor;
	}
	public void setCodigoProfesor(Profesor codigoProfesor) {
		this.codigoProfesor = codigoProfesor;
	}
	
}

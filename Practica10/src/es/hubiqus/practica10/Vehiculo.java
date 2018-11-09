/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.hubiqus.practica10;

/**
 * Representa un vehículo
 * @author Lenguaje Java Básico
 */
public class Vehiculo {
	private String matricula;
    private Color color;
    private boolean reservado;
    private int precio;
    
    public Vehiculo(){
    	
    }
    
    /**
     * Constructor
     * @param matricula
     * @param color
     * @param reservado
     * @param precio
     */
    public Vehiculo(String matricula, Color color, boolean reservado, int precio){
        this.matricula = matricula;
        this.color = color;
        this.reservado = reservado;
        this.precio = precio;
    }

    public boolean isReservado() {
        return reservado;
    }

    public Color getColor() {
        return color;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getPrecio() {
        return precio;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }
    
    @Override
    public String toString(){    	
    		return "Matricula: " + getMatricula() + " Color: " + getColor() 
    		+ " Reservado: " + (isReservado()?"SI":"NO") + 	" Precio: " + getPrecio()+ "\n";
    }
}

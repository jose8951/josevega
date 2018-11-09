/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.hubiqus.practica10;

/**
 * Representa una moto
 * @author Lenguaje Java Básico
 */
public class Moto extends Vehiculo {
	private int cilindrada;
	
	public Moto(){
    	
    }
    
    public Moto(String matricula, Color color, boolean reservado, int precio, int cilindrada){
        super(matricula,color,reservado,precio);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
    
   
    @Override
    public String toString(){
        return super.toString() +
        		"Cilindrada: " + this.cilindrada+ "\n";
    }
}


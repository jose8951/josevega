package es.hubiqus.practica10;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Representa un coche
 * @author Lenguaje Java Básico
 */
public class Coche extends Vehiculo {
	private int numeroPlazas;
    private boolean extras;
    
    public Coche(){
    	
    }
    
    public Coche(String matricula, Color color, boolean reservado, int precio, int np, boolean extras){
        super(matricula,color,reservado,precio);
    		this.numeroPlazas = np;
        this.extras = extras;
    }

    public int getNumeroPlazas() {
        return numeroPlazas;
    }

    public boolean getExtras() {
        return extras;
    }

    public void setExtras(boolean extras) {
        this.extras = extras;
    }

    public void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }
    
    @Override
    public String toString(){
        return super.toString()+
        		"Plazas: " + numeroPlazas + " Extras: " + extras + "\n";
    }
}

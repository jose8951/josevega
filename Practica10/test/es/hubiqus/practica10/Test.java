/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.hubiqus.practica10;

/**
 *
 * @author Lenguaje Java Básico
 */
public class Test {
	
	public static void main(String[] args){
		Concesionario concesionario = new Concesionario("BIZNAUTO", "Avd. Ortega", 5551234);
		
		//concesionario.guardar(new Coche("123ABC",Color.ROJO,false,10000,3,true));
        //concesionario.guardar(new Coche("456JKL",Color.ROJO,false,15000,5,false));
        //concesionario.guardar(new Coche("789ASD",Color.AZUL,false,12000,5,true));
        //concesionario.guardar(new Moto("012QWE",Color.VERDE,false,18000,500));
        //concesionario.guardar(new Moto("133RTY",Color.ROJO,false,15000,250));
        
		//Lanzar menu
		new Menu(concesionario).run();
	}
	
}

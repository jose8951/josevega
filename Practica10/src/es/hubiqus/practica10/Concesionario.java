package es.hubiqus.practica10;

import java.util.Arrays;

/**
 * Concesionario de veha­culos
 * @author Lenguaje Java BÃ¡sico
 */
public class Concesionario {

     private String nombre;
     private String direccion;
     private int telefono;
     private Vehiculo[] vehiculos;
     public final static int TAM = 5;

     /**
      * Constructor basico
      */
     public Concesionario() {
          vehiculos = new Vehiculo[TAM];
     }

     /**
      * Constructor completo
      * @param nom
      * @param dir
      * @param telf
      */
     public Concesionario(String nom, String dir, int telf) {
    	 	this();
        this.nombre = nom;
        this.direccion = dir;
        this.telefono = telf;          
     }

     public void setNombre(String nombre) {
          this.nombre = nombre;
     }

     public void setDireccion(String direccion) {
          this.direccion = direccion;
     }

     public void setTelefono(int telefono) {
          this.telefono = telefono;
     }

     public String getDireccion() {
          return direccion;
     }

     public String getNombre() {
          return nombre;
     }

     public int getTelefono() {
          return telefono;
     }

     @Override
     public String toString() {
          String cad;
          cad = "Concesionario: " + "\n" +
                  "Nombre: " + getNombre() + "\n" +
                  "Direccion: " + getDireccion() + "\n" +
                  "Telefono: " + getTelefono() + "\n";
          for (int i = 0; i < TAM; i++) {
               if (this.vehiculos[i] != null) {
                    cad = cad + "Vehiculo =>" + vehiculos[i] + "\n";
               }
          }
          return cad;
     }
     
     /**
      * Guardar un vehÃ­culo
      * @param v
      */
     public void guardar(Vehiculo v){
	    	 int indice = 0;
	    	 boolean enc = false;
	    	 while (indice < vehiculos.length && !enc){
	    		 enc = vehiculos[indice++] == null;
	    	 }
	    	 
	    	 //Si hay hueco
	    	 if (enc){
	    		 vehiculos[--indice] = v;
	    	 }
     }

     /**
      * Busca un vehÃ­culo a travÃ©s de su matrÃ­cula
      * @param matricula
      * @return vehÃ­culo buscado si lo encuentra, null en otro caso
      */
     public Vehiculo buscar(String matricula) {
          boolean encontrado = false;
          Vehiculo veh = null;
          int cont = 0;
          while ((!encontrado) && (cont < TAM)) {
               if (vehiculos[cont] != null && 
            		   vehiculos[cont].getMatricula().equalsIgnoreCase(matricula)) {
                    encontrado = true;
                    veh = vehiculos[cont];
               }
               cont++;
          }
          return veh;
     }
     
     /**
      * Buscar vehÃ­culos segÃºn criterio de filtrado
      * @param matricula ocurrencia parcial de matrÃ­cula
      * @param color color del vehÃ­culo
      * @param min rango de precio
      * @param max rango de precio
      * @return lista de vehÃ­culos encontrados
      */
     public Vehiculo[] buscar(String matricula, Color color, int min, int max) {
	    	 Vehiculo[] res = new Vehiculo[TAM];
	    	 int indice = 0;
	    	 
	    	 for (Vehiculo v: vehiculos){
	    		 if (v != null && comprobar(v, matricula, color, min, max)){
	    			 //Si cumple con el criterio se agrega al array
	    			 res[indice++] = v;
	    		 }
	    	 }
	    	 
	    	 //Compactar array eliminando todos los nulos del final
	    	 res = Arrays.copyOf(res, indice);
	    	 
	    	 return res;
     }
     
     /**
      * Comprobar el criterio
      * @param v elemento a comprobar
      * @param matricula ocurrencia parcial de matrÃ­cula
      * @param color color del vehÃ­culo
      * @param min rango de precio
      * @param max rango de precio
      * @return true si lo cumple, false en otro caso
      */
     private boolean comprobar(Vehiculo v, String matricula, Color color, int min, int max){
    	 return (matricula == null || 
    			 matricula.isEmpty() || 
    			 v.getMatricula().contains(matricula)) || //Si la matrÃ­cula es nula o vacÃ­a no miro, en otro caso ver si la contiene
    			(color == null ||
    				v.getColor() == color) || //Si el color es nulo o vacÃ­o no lo miro, en otro caso coincidencia completa
    			(v.getPrecio() >= min && v.getPrecio() <= max); //El rango de precios es obligatorio, NO TENGO FORMA DE PASARLO VACÃ�O
     }
     
     /**
      * Reservar un vehÃ­culo
      * @param matricula
      * @return vehÃ­culo reservado si lo encuentra, null en otro caso
      */
     public Vehiculo reservar(String matricula){
    	 	Vehiculo veh = this.buscar(matricula);
    	 	
    	 	if (veh != null){
    	 		veh.setReservado(true);
    	 	}
    	 	return veh;
     }
}


package es.hubiqus.practica10;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Menu de opciones, por defecto salida y entrada estandar
 * Posee m√©todos para modificar el interfaz
 * @author ajurado
 *
 */
public class Menu {
	
	private static final int OPT_EXIT = 0;
	private static final int OPT_ICAR = 1;
	private static final int OPT_IMOT = 2;
	private static final int OPT_LIST = 3;
	private static final int OPT_RESR = 4;
	private static final int OPT_FIND = 5;
	
	//private PrintStream out;
	//private InputStream in;
	private Scanner sc =new Scanner(System.in);
	private Concesionario concesionario;
	
	//public void setOut(PrintStream out) {
	//	this.out = out;
	//}

	//public void setIn(InputStream in) {
	//	this.in = in;
	//	this.sc = 
	//	sc.useDelimiter(System.lineSeparator());
	//}

	/**
	 * Crear un men√∫ para el concesionario
	 * @param concesionario
	 */
	public Menu(Concesionario concesionario) {
		this.concesionario = concesionario;
		//Por defecto salida y entrada estandar
		//this.setOut(System.out);
		//this.setIn(System.in);
	}

	public void run(){
		int opcion = -1;
		//Ejecutar hasta que seleccione opci√≥n salir
		while (opcion != OPT_EXIT){
			//Mostrar el menu de opciones
			menu();
			opcion = sc.nextInt();
			
			//Lanzar metodo en funcion de opcion pulsada
			switch (opcion){
				case 
				OPT_ICAR: coche(); 
				break;
				case 
				OPT_IMOT: moto(); 
				break;
				case 
				OPT_RESR: buscar(true); 
				break;
				case 
				OPT_FIND: buscar(false); 
				break;
				case 
				OPT_LIST: listar(); 
				break;
			}
		}
	}
	
	/**
	 * Listar vehi≠culos
	 */
	private void listar(){
		System.out.println("Introduzca matra≠cula:");		
		String matricula = sc.next();
		System.out.println("Introduzca color:");
		Color color = color(sc.next());
		System.out.println("Introduzca precio ma≠nimo y ma°ximo:");
		int min = sc.nextInt();
		int max = sc.nextInt();
		Vehiculo[] lista = concesionario.buscar(matricula, color, min, max);
		for (Vehiculo v: lista){
			System.out.println(v);
		}
	}
	
	/**
	 * Insertar coche solicitando valores a la entrada
	 */
	private void coche(){
		Coche coche = new Coche();
		System.out.println("Introduzca matri≠cula:");
		coche.setMatricula(sc.next());
		System.out.println("Introduzca color:");
		coche.setColor(color(sc.next()));		
		System.out.println("Introduzca precio:");
		coche.setPrecio(sc.nextInt());
		System.out.println("Introduzca numero de plazas:");
		coche.setNumeroPlazas(sc.nextInt());
		System.out.println("Tiene extras?: S/N");
		coche.setExtras(sc.next().equalsIgnoreCase("S"));
		
		//Introducir en el concesionario
		concesionario.guardar(coche);
	}
	
	/**
	 * Insertar moto solicitando valores a la entrada
	 */
	private void moto(){
		Moto moto = new Moto();
		System.out.println("Introduzca matra≠cula:");
		moto.setMatricula(sc.next());
		System.out.println("Introduzca color:");
		moto.setColor(color(sc.next()));		
		System.out.println("Introduzca precio:");
		moto.setPrecio(sc.nextInt());
		System.out.println("Introduzca cc:");
		moto.setCilindrada(sc.nextInt());
		
		//Introducir en el concesionario
		concesionario.guardar(moto);
	}
	
	/**
	 * Cadena de caracteres a color
	 * @param str
	 * @return
	 */
	private Color color(String str){
		switch (str.toUpperCase()){
			case "ROJO": 
			return Color.ROJO;
			case "VERDE": 
			return Color.VERDE;
			case "AZUL": 
			return Color.AZUL;
			default: 
			return null;
		}
//		return Color.valueOf(str.toUpperCase());
	}
	
	/**
	 * Buscar por matra≠cula solicitada a la entrada
	 * @param reservar indica si se reserva el veha≠culo buscado o no
	 */
	private void buscar(boolean reservar){
		System.out.println("Introduzca matri≠cula:");
		String matricula = sc.next();
		//Buscar en el concesionario
		Vehiculo vehiculo = null;
		if (reservar){
			vehiculo = concesionario.reservar(matricula);
		}else{
			vehiculo = concesionario.buscar(matricula);
		}
		if (vehiculo == null){
			System.out.println("NO encontrado");
		}else{
			System.out.println(vehiculo);
		}
		
	}
	
	/**
	 * Men√∫ de opciones
	 */
	private void menu(){
		System.out.println("1-Introducir coche");
		System.out.println("2-Introducir moto");
		System.out.println("3-Ver vehiculos");
		System.out.println("4-Reservar");
		System.out.println("5-Buscar");
		System.out.println("0-Salir");
	}
	
	@Override
	protected void finalize(){
		//Liberar scanner
		sc.close();
	}
}

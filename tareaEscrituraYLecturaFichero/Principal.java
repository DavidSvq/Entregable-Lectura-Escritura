/***
 * Clase Principal, que contiene el menú principal y sus opciones. Para ello, recurro
 * a un Switch. Además, incorpora 2 métodos estáticos: para mostrar las opciones del menú
 * al usuario por pantalla y para avisar si no se introduce una opción disponible.
 * 
 * En esta clase, use el método isEmpty() para comprobar si el arrayList tiene datos
 * tras la carga del archivo .csv.
 * Utilizo la clase InputMismatchException para las excepciones que pueda lanzar cuando
 * se espera un dato y se recibe otro por teclado (normalmente suele afectar a números al
 * introducir una letra, o si espera un entero, recibir con decimales).
 */

package tareaEscrituraYLecturaFichero;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		
		//Creación del scanner
		Scanner sc = new Scanner(System.in);
		
		//Creación clases usadas para mostrar las películas
		MostrarPelicula mostrarListaPelicula = new MostrarListaPelicula();
		MostrarPelicula mostrarPorGenero = new MostrarPorGenero();
		MostrarPelicula mostrarPorAntiguedad = new MostrarPorAntiguedad();
		MostrarPelicula mostrarPorTodosLosGeneros = new MostrarPorTodosLosGeneros();
		
		//Creación variable para el menu principal
		int opcionMenu = Constantes.VALOR_INICIAL;
		
		//Carga del archivo.csv, usando la clase LectorCsv, en un arrayList
		ArrayList<Pelicula> peliculas = LectorCsv.leerArchivo("G:\\Mi unidad\\Segundo Trimestre\\Programación\\Java\\tareaEscrituraYLecturaFichero\\Peliculas.csv");
		
		//Condicional para comprobar que la lista no este vacia y poder operar con ella
		if(peliculas.isEmpty()) {
			System.out.println("La lista de películas está vacia.");
		}
		else {
			//Bucle hasta que se pulse la opcion 6 para salir del programa
			while(opcionMenu != Constantes.OPCION_SALIDA_MENU_PRINCIPAL) {
				try {
					Principal.mostrarMenuPrincipal();
					opcionMenu = sc.nextInt();
					Principal.avisoOpcionIncorrecta(opcionMenu, Constantes.OPCION_INICIAL_MENU, Constantes.OPCION_SALIDA_MENU_PRINCIPAL);
					
					//Realización de la opción elegida del menú
					switch (opcionMenu) {
					case 1:
						mostrarListaPelicula.mostrar(peliculas);
						break;
					case 2:
						mostrarPorGenero.mostrar(peliculas);
						break;
					case 3:
						Collections.sort(peliculas, new OrdenarPorTitulo());
						mostrarListaPelicula.mostrar(peliculas);
						break;
					case 4:
						mostrarPorAntiguedad.mostrar(peliculas);
						break;
					case 5:
						mostrarPorTodosLosGeneros.mostrar(peliculas);
						break;
					case 6:
						Collections.sort(peliculas);
						mostrarListaPelicula.mostrar(peliculas);
						break;
					default:
						break;
					}
				} catch (InputMismatchException e) {
					System.out.println(e + " Error. Debe introducir un número entero.");
					sc.nextLine();
				}
			}
		}
	}
	
	//Método que contiene lo mostrado por pantalla al usuario en el menu principal
	private static void mostrarMenuPrincipal() {
		System.out.println("Pulse 1 para mostrar las peliculas.");
		System.out.println("Pulse 2 para mostrar por un genero.");
		System.out.println("Pulse 3 para ordenar y mostrar por título.");
		System.out.println("Pulse 4 para mostrar películas por antiguedad");
		System.out.println("Pulse 5 para mostrar las peliculas por genero.");
		System.out.println("Pulse 6 para mostrar las peliculas en orden por defecto.");
		System.out.println("Pulse 7 para salir.");
	}
	
	//Método que avisa al usuario por pantalla si no pulsó una opción correcta
	public static void avisoOpcionIncorrecta(int opcionElegida, int opcion1, int opcion2) {
		if (opcionElegida < opcion1 || opcionElegida > opcion2) {
			System.out.println("Pulse una opción disponible.");
		}
	}

}

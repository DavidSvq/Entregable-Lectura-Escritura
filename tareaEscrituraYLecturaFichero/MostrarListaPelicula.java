/**
 * Información general:
 * Esta clase era un método en la clase Pelicula, pero para aligerar la clase Pelicula de
 * responsabilidades y código, cree varias clases. Aunque inicialmente era una sola con todos
 * los métodos mostrar, pero también me parecio que empezaba a tener bastante código, por lo que
 * implemente con una interfaz y clases específicas para cada opción de mostrar las películas.
 * Tal como acuerda su interfaz, contiene un método que no devuelve nada (void) y recibe un 
 * ArrayList de Peliculas por parámetros.
 * 
 * Información particular de la clase:
 * Esta muestra simplemente la lista, sin ningún tipo de organización especificada, mediante
 * un bucle for each.
 */


package tareaEscrituraYLecturaFichero;

import java.util.ArrayList;

public class MostrarListaPelicula implements MostrarPelicula {

	@Override
	public void mostrar(ArrayList<Pelicula> list) {
		System.out.println("Listado de peliculas vistas: ");
		for (Pelicula pelicula : list) {
			System.out.println(pelicula);
		}
		
	}



}

/**
 * Información general: 
 * Leer párrafo de la clase MostrarListaPelicula.
 * 
 * Información particular de la clase:
 * Esta muestra una la lista mediante un bucle for each y usando el método equals de la clase
 * String para el atributo genero que se compara con el dado por el usuario. 
 * Uso de una variable para verificar que al menos hay una película.
 */

package tareaEscrituraYLecturaFichero;

import java.util.ArrayList;
import java.util.Scanner;

public class MostrarPorGenero implements MostrarPelicula {
	
	public void mostrar(ArrayList<Pelicula> list) {
		//Creación de escaner y variables usadas
		Scanner sc = new Scanner(System.in);
		String genero;
		int contadorAlMenosUna = Constantes.VALOR_INICIAL;
		
		//Solicitud del género a buscar
		System.out.println("Introduce un genero: ");
		genero = sc.nextLine();
		
		//Mostrar peliculas mediante bucle for each
		System.out.println("Películas del género " + genero);
		for (Pelicula pelicula : list) {
			if (pelicula.getGenero().equalsIgnoreCase(genero)) {
				System.out.println(pelicula);
				contadorAlMenosUna++;
			}
		}
		//Condicional para informar si no hay películas del genero solicitado
		if(contadorAlMenosUna <= Constantes.VALOR_INICIAL) {
			System.out.println("No hay películas del género indicado.");
		}
	}
}

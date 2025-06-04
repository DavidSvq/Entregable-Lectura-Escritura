/***
 * Información general: 
 * Leer párrafo de la clase MostrarListaPelicula.
 * 
 * Información particular de la clase:
 * Como además, de mostrar por genero también se cuenta cuántas películas tiene cada genero, 
 * me valgo de la clase HaspMap para ello, estableciendo el género como clave y las veces que
 * se repite como valor. Tanto para indicar el nº de películas de cada género, como para mostrar
 * las por pantalla uso bucles for.
 * 
 * Nota: Aunque esta clase esta diseñada para realizar una única responsabilidad, tiene una
 * pequeña lógica o proceso implementado para contar el número de películas que hay de cada 
 * género. Considero que no supone una responsabilidad nueva en la clase.
 */


package tareaEscrituraYLecturaFichero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MostrarPorTodosLosGeneros implements MostrarPelicula {
	
	@Override
	public void mostrar(ArrayList<Pelicula> list) {
		HashMap<String, Integer> nPeliculasPorGenero = new HashMap<>();

		//Bucle que traspasa los datos de la lista de películas, a un hashMap en base al género como clave y las veces que
		// se repite dicho género como valor.
		for (Pelicula pelicula : list) {
			nPeliculasPorGenero.put(pelicula.getGenero(), nPeliculasPorGenero.getOrDefault(pelicula.getGenero(), 0) + 1);
		}
		
		//Bucle para mostar el hashMap y contiene el bucle para mostrar las películas
		for (Map.Entry<String, Integer> entrada : nPeliculasPorGenero.entrySet()) {
			String clave = entrada.getKey();
			Integer valor = entrada.getValue();
			if(valor == Constantes.UNIDAD_MINIMA) {
				System.out.println("Del género " + clave + " hay esta película:");
			}
			else {
				System.out.println("Del género " + clave + " hay estas " + valor + " películas:");
			}
			//Bucle para recorrer e imprimir las peliculas para cada género
			for (Pelicula pelicula : list) {
				if(clave.equalsIgnoreCase(pelicula.getGenero())) {
					System.out.println(pelicula);
				}
			}
			System.out.println("");
			
		}
		System.out.println("");
	}
}

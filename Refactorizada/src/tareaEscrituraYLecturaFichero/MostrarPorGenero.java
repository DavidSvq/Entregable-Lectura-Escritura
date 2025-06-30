package tareaEscrituraYLecturaFichero;

import java.util.List;
import java.util.Scanner;

public class MostrarPorGenero implements MostrarPelicula {
	
	private int countAtLeastOne;
	
	public void mostrar(List<Pelicula> list) {
		
		countAtLeastOne = Constantes.VALOR_INICIAL;
		
		showMovies(list, requestGenreToFilter());
		
		informNoMoviesFound();
	}

	private void showMovies(List<Pelicula> list, String genero) {
		System.out.println("Películas del género " + genero);
		showGenreMovies(list, genero);
	}

	private void showGenreMovies(List<Pelicula> list, String genero) {
		for (Pelicula pelicula : list) {
			checkGenreAndDisplayIfMatches(genero, pelicula);
		}
	}

	private void checkGenreAndDisplayIfMatches(String genero, Pelicula pelicula) {
		if (pelicula.getGenero().equalsIgnoreCase(genero)) {
			System.out.println(pelicula);
			countAtLeastOne++;
		}
	}

	private String requestGenreToFilter() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un genero: ");
		return sc.nextLine();
	}
	
	private void informNoMoviesFound() {
		if(countAtLeastOne <= Constantes.VALOR_INICIAL) {
			System.out.println("No hay películas del género indicado.");
		}
	}
}

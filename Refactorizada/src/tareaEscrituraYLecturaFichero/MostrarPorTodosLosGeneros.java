package tareaEscrituraYLecturaFichero;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostrarPorTodosLosGeneros implements MostrarPelicula {
	
	@Override
	public void mostrar(List<Pelicula> list) {
		Map<String, Integer> nPeliculasPorGenero = new HashMap<>();
		
		buildGenreCountMapFromList(list, nPeliculasPorGenero);
		
		displayMoviesByGenre(list, nPeliculasPorGenero);
	}
	
	private void buildGenreCountMapFromList(List<Pelicula> list, Map<String, Integer> nPeliculasPorGenero) {
		for (Pelicula pelicula : list) {
			nPeliculasPorGenero.put(pelicula.getGenero(), nPeliculasPorGenero.getOrDefault(pelicula.getGenero(), 0) + 1);
		}
	}

	private void displayMoviesByGenre(List<Pelicula> list, Map<String, Integer> nPeliculasPorGenero) {
		for (Map.Entry<String, Integer> entrada : nPeliculasPorGenero.entrySet()) {
			String clave = entrada.getKey();
			Integer valor = entrada.getValue();
			
			displayGenreHeader(clave, valor);
			
			showMovies(list, clave);
			
			System.out.println("");
		}
		System.out.println("");
	}

	private void displayGenreHeader(String clave, Integer valor) {
		if(valor == Constantes.UNIDAD_MINIMA) {
			System.out.println("Del género " + clave + " hay esta película:");
		}
		else {
			System.out.println("Del género " + clave + " hay estas " + valor + " películas:");
		}
	}

	private void showMovies(List<Pelicula> list, String clave) {
		for (Pelicula pelicula : list) {
			showMovieIfGenreMatches(clave, pelicula);
		}
	}

	private void showMovieIfGenreMatches(String clave, Pelicula pelicula) {
		if(isGenreMatch(clave, pelicula)) {
			System.out.println(pelicula);
		}
	}

	private boolean isGenreMatch(String clave, Pelicula pelicula) {
		return clave.equalsIgnoreCase(pelicula.getGenero());
	}	
}

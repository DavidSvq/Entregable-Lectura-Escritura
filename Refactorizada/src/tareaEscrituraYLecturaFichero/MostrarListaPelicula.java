package tareaEscrituraYLecturaFichero;

import java.util.List;

public class MostrarListaPelicula implements MostrarPelicula {

	@Override
	public void mostrar(List<Pelicula> list) {
		System.out.println("Listado de peliculas vistas: ");
		displayMovies(list);
		
	}

	private void displayMovies(List<Pelicula> list) {
		for (Pelicula pelicula : list) {
			System.out.println(pelicula);
		}
	}



}

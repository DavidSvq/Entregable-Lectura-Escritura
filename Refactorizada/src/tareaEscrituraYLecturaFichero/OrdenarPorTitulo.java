package tareaEscrituraYLecturaFichero;

import java.util.Comparator;

public class OrdenarPorTitulo implements Comparator<Pelicula> {

	@Override
	public int compare(Pelicula p1, Pelicula p2) {
		return p1.getTitulo().compareTo(p2.getTitulo());
	}

}

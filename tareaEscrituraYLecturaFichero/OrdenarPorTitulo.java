/**
 * Clase que implementa la interfaz Comparator, para sobreescribir el método compare.
 * En este caso concreto, establece el order de comparación alfabéticamente por título.
 */

package tareaEscrituraYLecturaFichero;

import java.util.Comparator;

public class OrdenarPorTitulo implements Comparator<Pelicula> {

	@Override
	public int compare(Pelicula p1, Pelicula p2) {
		return p1.getTitulo().compareTo(p2.getTitulo());
	}

}

/**
 * Interfaz que declara un sólo método para mostrar información de las películas. 
 * El método no devuelve nada (void) y recibe por parámetros un arrayList de la
 * clase Pelicula.
 */

package tareaEscrituraYLecturaFichero;

import java.util.ArrayList;

public interface MostrarPelicula {
	void mostrar(ArrayList<Pelicula> list);
}

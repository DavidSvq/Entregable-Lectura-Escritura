/**
 * Esta clase existe únicamente con la finalidad de contener todas las constantes que se usan
 * en el programa (ayudando así, a la eliminación de números "mágicos".
 */
package tareaEscrituraYLecturaFichero;

import java.time.Year;

public abstract class Constantes {
	public final static int OPCION_INICIAL_MENU = 1;
	public final static int OPCION_SALIDA_MENU_PRINCIPAL = 7;
	public final static int VALOR_INICIAL = 0;
	public final static int PRIMERA_PELICULA = 1895;
	public final static int UNIDAD_MINIMA = 1;
	public final static int ANTIGUEDADMAXIMA = Year.now().getValue() - Constantes.PRIMERA_PELICULA;
}

/***
 * Información general: 
 * Leer párrafo de la clase MostrarListaPelicula.
 * 
 * Información particular de la clase:
 * Esta muestra las películas según cierta antiguedad, que es solicitada al usuario por teclado.
 * Aunque el ejercicio no lo dice, añado una funcionalidad extra donde se pregunta al usuario
 * si quiere que las películas sean más o menos antiguas con respecto a lo indicado.
 * Para obtener la antiguedad de cada película uso la clase Year con su método .now() más el
 * métedo getValue para obtener el año en formato int.
 * Para el control de excepciones utilizo la clase InputMismatchException, además, establezco 2 
 * variables booleanas de control(hay dos entradas de datos por teclado, por si salta la 
 * excepción vuelva a solicitarse los datos).
 * Se usa condicional por si se introduce una antiguedad erronea, por ejemplo negativo o más 
 * tiempo de que se invento el cine. Con su else para ejecutar en caso que todo esté correcto, 
 * este a su vez contiene una condición que establece si se desea que sea más o menos la 
 * antiguedad dada con respecto a la película.
 * 
 * Nota: Aunque esta clase esta diseñada para realizar una única responsabilidad, tiene una
 * pequeña lógica implementada para calcular las antiguedades de las películas. Considero que
 * no supone una responsabilidad nueva en la clase.
 */

package tareaEscrituraYLecturaFichero;

import java.time.Year;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MostrarPorAntiguedad implements MostrarPelicula {
	
	//Creación del escaner
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void mostrar(ArrayList<Pelicula> list) {
		
		//Creación de variables usadas en el método
		int antiguedadPelicula = Constantes.VALOR_INICIAL;
		int contadorAlMenosUna = Constantes.VALOR_INICIAL;
		int opcionAntiguedad = Constantes.VALOR_INICIAL;
		int antiguedad = Constantes.VALOR_INICIAL;
		boolean antiguedadCorrecta = false;
		boolean antiguedadEleccionCorrecta = false;
		
		//Bucle por si salta la excepcion
		while(!antiguedadCorrecta && !antiguedadEleccionCorrecta) {
			try {
				//Solicitud por teclado de la antiguedad
				System.out.println("Introduce la antiguedad en años:");
				antiguedad = sc.nextInt();
				antiguedadCorrecta = true;
				//Solicitud por teclado de si es más o menos la antiguedad
				do {
					System.out.println("Pulsa 0 para películas con menos antiguedad");
					System.out.println("Pulsa 1 para películas con más antiguedad");
					opcionAntiguedad = sc.nextInt();
					
					//Método estático de la clase Principal
					Principal.avisoOpcionIncorrecta(opcionAntiguedad, Constantes.VALOR_INICIAL, Constantes.UNIDAD_MINIMA);
					
					antiguedadEleccionCorrecta = true;
				} while (opcionAntiguedad < Constantes.VALOR_INICIAL || opcionAntiguedad > Constantes.UNIDAD_MINIMA);
			}
			catch (InputMismatchException e) {
				System.out.println(e + " Error, debe introducir un número entero.");
				sc.nextLine();
				antiguedadCorrecta = false;
				antiguedadEleccionCorrecta = false;
			}
		}
		
		//Comprobación de si antiguedad es válida o no, para seguir operando código 
		if(antiguedad < Constantes.VALOR_INICIAL || antiguedad > Constantes.ANTIGUEDADMAXIMA) {
			System.out.println("La antiguedad proporcionada no es válida.");
		}
		else {
			
			//Acción para el caso que las películas tengan menos antiguedad de la referida
			if(opcionAntiguedad == Constantes.VALOR_INICIAL) {
				System.out.println("Películas con menos de " + antiguedad + " años:");
				for (Pelicula pelicula : list) {
					antiguedadPelicula = Year.now().getValue() - pelicula.getAnio();
					if (antiguedadPelicula < antiguedad) {
						System.out.println(pelicula);
						contadorAlMenosUna++;
					}
				}
			}
			//Acción para el caso que las películas tengan más antiguedad de la referida
			else {
				System.out.println("Películas con más de " + antiguedad + " años:");
				for (Pelicula pelicula : list) {
					antiguedadPelicula = Year.now().getValue() - pelicula.getAnio();
					if (antiguedadPelicula > antiguedad) {
						System.out.println(pelicula);
						contadorAlMenosUna++;
					}
				}
			}
			
			//Condición que avisa al usuario si no hubiera ninguna película que cumpla
			if(contadorAlMenosUna <= Constantes.VALOR_INICIAL) {
				System.out.println("No hay peliculas vistas con la antiguedad indicada.");
			}
		}

	}

}

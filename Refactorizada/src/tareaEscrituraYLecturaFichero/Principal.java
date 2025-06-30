package tareaEscrituraYLecturaFichero;

import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Principal {
	
	private static MostrarPelicula mostrarListaPelicula = new MostrarListaPelicula();
	private static MostrarPelicula mostrarPorGenero = new MostrarPorGenero();
	private static MostrarPelicula mostrarPorAntiguedad = new MostrarPorAntiguedad();
	private static MostrarPelicula mostrarPorTodosLosGeneros = new MostrarPorTodosLosGeneros();
	
	private static Map<Integer,MostrarPelicula> actions = new HashMap<>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int opcionMenu = Constantes.VALOR_INICIAL;
		
		List<Pelicula> peliculas = uploadFile();
		
		if(peliculas.isEmpty()) {
			System.out.println("La lista de películas está vacia.");
		}
		else {
			startActions();
			showOptionsUntilExit(sc, opcionMenu, peliculas);
		}
	}

	private static void showOptionsUntilExit(Scanner sc, int opcionMenu, List<Pelicula> peliculas) {
		while(opcionMenu != Constantes.OPCION_SALIDA_MENU_PRINCIPAL) {
			try {
				
				Principal.mostrarMenuPrincipal();
				opcionMenu = sc.nextInt();
				Principal.avisoOpcionIncorrecta(opcionMenu, Constantes.OPCION_INICIAL_MENU, Constantes.OPCION_SALIDA_MENU_PRINCIPAL);
				
				MostrarPelicula action = actions.get(opcionMenu);
				
				applyMenuAction(opcionMenu, peliculas, action);
				
			} catch (InputMismatchException e) {
				System.out.println(e + " Error. Debe introducir un número entero.");
				sc.nextLine();
			}
		}
	}

	private static List<Pelicula> uploadFile() {
		List<Pelicula> peliculas = LectorCsv.leerArchivo("G:\\Mi unidad\\Segundo Trimestre\\Programación\\Java\\tareaEscrituraYLecturaFichero\\Peliculas.csv");
		return peliculas;
	}

	private static void applyMenuAction(int opcionMenu, List<Pelicula> peliculas, MostrarPelicula action) {
		if(action != null) {
			action.mostrar(peliculas);
		}
		else if (opcionMenu == Constantes.OPCION_SALIDA_MENU_PRINCIPAL) {
		    System.out.println("Saliendo del programa...");
		}
	}
	
	private static void mostrarMenuPrincipal() {
		System.out.println("Pulse 1 para mostrar las peliculas.");
		System.out.println("Pulse 2 para mostrar por un genero.");
		System.out.println("Pulse 3 para ordenar y mostrar por título.");
		System.out.println("Pulse 4 para mostrar películas por antiguedad");
		System.out.println("Pulse 5 para mostrar las peliculas por genero.");
		System.out.println("Pulse 6 para mostrar las peliculas en orden por defecto.");
		System.out.println("Pulse 7 para salir.");
	}
	
	public static void avisoOpcionIncorrecta(int opcionElegida, int opcion1, int opcion2) {
		if (opcionElegida < opcion1 || opcionElegida > opcion2) {
			System.out.println("Pulse una opción disponible.");
		}
	}
	
	private static void startActions() {
		
		actions.put(1, mostrarListaPelicula);
		actions.put(2, mostrarPorGenero);
		actions.put(3, moviesList -> {
			Collections.sort(moviesList, new OrdenarPorTitulo());
			mostrarListaPelicula.mostrar(moviesList);
		});
		actions.put(4, mostrarPorAntiguedad);
		actions.put(5, mostrarPorTodosLosGeneros);
		actions.put(6, moviesList -> {
			Collections.sort(moviesList);
			mostrarListaPelicula.mostrar(moviesList);
		});
	}
}

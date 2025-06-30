package tareaEscrituraYLecturaFichero;

import java.time.Year;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MostrarPorAntiguedad implements MostrarPelicula {
	
	Scanner sc = new Scanner(System.in);
	
	private int contadorAlMenosUna = Constantes.VALOR_INICIAL;
	private int antiguedad = Constantes.VALOR_INICIAL;
	private int opcionAntiguedad = Constantes.VALOR_INICIAL;
	
	@Override
	public void mostrar(List<Pelicula> list) {
		
		boolean antiguedadCorrecta = false;
		boolean antiguedadEleccionCorrecta = false;
		
		requestAndValidateMovieAge(antiguedadCorrecta, antiguedadEleccionCorrecta);
		
		if(checkMovieReleaseYear()) {
			System.out.println("La antiguedad proporcionada no es válida.");
		}
		else {
			
			showMovies(list);
			
			informNoMoviesFound();
		}
	}

	private void requestAndValidateMovieAge(boolean antiguedadCorrecta, boolean antiguedadEleccionCorrecta) {
		while(!antiguedadCorrecta || !antiguedadEleccionCorrecta) {
			try {
				antiguedadCorrecta = getMovieAgeFromUser();
			
				antiguedadEleccionCorrecta = selectOlderOrNewerByMovieAge();
			}
			catch (InputMismatchException e) {
				System.out.println(e + " Error, debe introducir un número entero.");
				sc.nextLine();
				antiguedadCorrecta = false;
				antiguedadEleccionCorrecta = false;
			}
		}
	}

	private boolean getMovieAgeFromUser() {
		System.out.println("Introduce la antiguedad en años:");
		antiguedad = sc.nextInt();
		return true;
	}
	
	private boolean selectOlderOrNewerByMovieAge() {
		do {
			System.out.println("Pulsa 0 para películas con menos antiguedad");
			System.out.println("Pulsa 1 para películas con más antiguedad");
			opcionAntiguedad = sc.nextInt();
			
			Principal.avisoOpcionIncorrecta(opcionAntiguedad, Constantes.VALOR_INICIAL, Constantes.UNIDAD_MINIMA);
			
		} while (opcionAntiguedad < Constantes.VALOR_INICIAL || opcionAntiguedad > Constantes.UNIDAD_MINIMA);
		
		return true;
	}

	private boolean checkMovieReleaseYear() {
		return antiguedad < Constantes.VALOR_INICIAL || antiguedad > Constantes.ANTIGUEDADMAXIMA;
	}

	private void showMovies(List<Pelicula> list) {
		displayMoviesByAge(list, opcionAntiguedad == Constantes.VALOR_INICIAL);
	}

	private void displayMoviesByAge(List<Pelicula> list, boolean showNewest) {
		showTitleSelection(showNewest);
		
		displayMovieAgeSelection(list, showNewest);
	}

	private void displayMovieAgeSelection(List<Pelicula> list, boolean showNewest) {
		for (Pelicula pelicula : list) {
			int antiguedadPelicula = Year.now().getValue() - pelicula.getAnio();
			boolean matchesSelection = antiguedadPelicula < antiguedad;
			
			if(showNewest == matchesSelection) {
				System.out.println(pelicula);
				contadorAlMenosUna++;
			}
		}
	}

	private void showTitleSelection(boolean showNewest) {
		if(showNewest) {
			System.out.println("Películas con menos de " + antiguedad + " años:");
		}else {
			System.out.println("Películas con más de " + antiguedad + " años:");
		}
	}

	private void informNoMoviesFound() {
		if(contadorAlMenosUna <= Constantes.VALOR_INICIAL) {
			System.out.println("No hay peliculas vistas con la antiguedad indicada.");
		}
	}
}

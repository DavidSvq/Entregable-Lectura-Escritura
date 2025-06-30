package tareaEscrituraYLecturaFichero;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class LectorCsv {
	
	public static List<Pelicula> leerArchivo(String ruta){
		
		return readFileUsingBufferedReader(ruta);
	}

	private static List<Pelicula> readFileUsingBufferedReader(String ruta) {
		
		try(BufferedReader br = new BufferedReader(new FileReader(ruta))){
			return readLinesFromBuffer(br);
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error en la lectura de datos: " + e.getMessage());
		}
		return Collections.emptyList();
	}

	private static List<Pelicula> readLinesFromBuffer(BufferedReader br) throws IOException {
		List<Pelicula> peliculas = new ArrayList<>();
		String linea;
		while((linea = br.readLine()) != null) {
			parsePelicula(linea).ifPresent(peliculas::add);
		}
		return peliculas;
	}

	private static Optional<Pelicula> parsePelicula(String linea) {
		String [] atributos = linea.split(",");
		
		if(attributesAreMissing(atributos)) return Optional.empty();
		
		return buildPeliculaIfValid(atributos);
	}
	
	private static boolean attributesAreMissing(String[] atributos) {
		return atributos.length < 4;
	}

	private static Optional<Pelicula> buildPeliculaIfValid(String[] atributos) {
		
		Optional<Integer> duracion = parseIntSafe(atributos[1]);
		Optional<Integer> anio = parseIntSafe(atributos[2]);
		
		if(isDurationOrYearInvalid(duracion, anio)) return Optional.empty();
		
		String titulo = atributos[0];
		String genero = atributos[3];
		
		return Optional.of(new Pelicula(titulo, duracion.get(), anio.get(), genero));
	}
	
	private static Optional<Integer> parseIntSafe(String valor){
		try {
			return Optional.of(Integer.parseInt(valor));
		}
		catch (NumberFormatException e) {
			return Optional.empty();
		}
	}
	
	private static boolean isDurationOrYearInvalid(Optional<Integer> duracion, Optional<Integer> anio) {
		return duracion.isEmpty() || anio.isEmpty();
	}
	
}

/***
 * Esta clase es creada para leer el fichero .csv y recibirlo en un ArrayList
 * Uso del método split de la clase String, que sirve para indicar que simbolo marca la separación entre
 * atributo y atributo (o campo y campo o dato y dato). 
 * Uso el método parseInt de la clase Integer para convertir el texto a formato entero,
 * en este caso concreto(se podria pasar a otro dato primitivo, como double, etc...).
 * Uso para las excepciones la clase IOException y la clase FileNotFoundException por si falla
 * la conexión o no se encuentra el archivo respectivamente.
 * 
 * Nota curiosa: Aquí este lector sólo esta escrito para una clase concreta, por lo que si no es con 
 * otra clase pelicula, es difícil su reutilización del código. Para poder evitar eso, se podría usar
 * una interfaz ya existente Function<> o la existente clase clazz usando reflexión) o un interfaz
 * propia que convierta T en el objeto requerido en ese momento (hacer un método Function 
 * propio). Así, podría reutilizarse el código con cualquier clase. 
 * No lo incluyo así, porque aún me falta profundizar un poco más en ello.
 */

package tareaEscrituraYLecturaFichero;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorCsv {
	public static ArrayList<Pelicula> leerArchivo(String ruta){
		
		//ArrayList para cargar el csv
		ArrayList<Pelicula> peliculas = new ArrayList<>();
		
		//Posible recogida de excepciones
		try(BufferedReader br = new BufferedReader(new FileReader("G:\\Mi unidad\\Segundo Trimestre\\Programación\\Java\\tareaEscrituraYLecturaFichero\\Peliculas.csv"))){
			String linea;
			//Bucle que recorre el archivo línea a línea mientras haya datos
			while((linea = br.readLine()) != null) {
				String [] atributos = linea.split(",");
				String titulo = atributos[0];
				int duracion = Integer.parseInt(atributos[1]);
				int anio = Integer.parseInt(atributos[2]);
				String genero = atributos[3];
				peliculas.add(new Pelicula(titulo, duracion, anio, genero));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return peliculas;
	}
}

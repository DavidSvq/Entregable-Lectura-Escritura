/**
 * Clase Pelicula, contiene los atributos correspondientes, así como el constructor 
 * y métodos "clásicos", tales cómo get y set necesarios, el toString y el compareTo,
 * ambos, sobreescritos.
 * El compareTo establece el orden "natural" de la clase primero por la duración, segundo
 * por el año (más antiguas primero) y por último por género.
 */

package tareaEscrituraYLecturaFichero;

public class Pelicula implements Comparable<Pelicula> {
	//Atributos
	private String titulo;
	private int anio;
	private int duracion;
	private String genero;
	
	//Constructor con todos los atributos
	public Pelicula(String titulo, int anio, int duracion, String categoria) {
		this.titulo = titulo;
		this.anio = anio;
		this.duracion = duracion;
		this.genero = categoria;
	}
	
	//Constructor vacío
	public Pelicula() {
		
	}

	//Get and set
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String categoria) {
		this.genero = categoria;
	}
	
	//ToString
	@Override
	public String toString() {
		return "[#Titulo: " + titulo + " #Año: " + anio + " #Duracion: " + duracion + " #Genero: " + genero
				+ "]";
	}
	
	//CompareTo
	@Override
	public int compareTo(Pelicula p) {
		int resultado = this.duracion - p.getDuracion();
		if(resultado == 0) {
			resultado = - (this.anio - p.getAnio());
			if(resultado == 0) {
				resultado = this.genero.compareTo(p.getGenero());
			}
		}
		return resultado;
	}
}

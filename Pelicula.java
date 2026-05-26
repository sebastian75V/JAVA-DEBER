package Clases;
import java.util.Objects;

public class Pelicula {
    String nombre, director, genero;
    int duracion, anio;
    double rating;

    public Pelicula(String nombre, String director, String genero, int duracion, int anio, double rating) {
        this.nombre = nombre;
        this.director = director;
        this.genero = genero;
        this.duracion = duracion;
        this.anio = anio;
        this.rating = rating;
    }

    public String toString() {
        return nombre + " | " + genero + " | " + duracion + " horas | " + anio + " |  " + rating;
    }

    // Para evitar repetidos en HashSet
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pelicula)) return false;
        Pelicula p = (Pelicula) o;
        return nombre.equalsIgnoreCase(p.nombre);
    }

    public int hashCode() {
        return Objects.hash(nombre.toLowerCase());
    }
    public String getNombre(){
        return nombre;
    }
    public int getDuracion(){
        return duracion;
    }
}
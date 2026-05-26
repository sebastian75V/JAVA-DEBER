import Clases.Pelicula;
import java.util.*;

public class TestPelicula {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pelicula> lista = new ArrayList<>();
        Set<Pelicula> set = new HashSet<>();
        Map<String, List<Pelicula>> mapa = new HashMap<>();
        String continuar;

        do {
            System.out.println("\n--- Nueva Pelicula ---");

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Director: ");
            String director = sc.nextLine();

            System.out.print("Genero: ");
            String genero = sc.nextLine();

            System.out.print("Duracion: ");
            int duracion = sc.nextInt();

            System.out.print("Año: ");
            int anio = sc.nextInt();

            System.out.print("Rating: ");
            double rating = sc.nextDouble();
            sc.nextLine(); // limpiar buffer

            Pelicula p = new Pelicula(nombre, director, genero, duracion, anio, rating);

            if (set.add(p)) {
                lista.add(p);

                mapa.putIfAbsent(genero, new ArrayList<>());
                mapa.get(genero).add(p);

                System.out.println(" Pelicula agregada");
            } else {
                System.out.println(" Pelicula repetida");
            }

            System.out.print("¿Agregar otra? (si/no): ");
            continuar = sc.nextLine();

        } while (continuar.equalsIgnoreCase("si"));

        System.out.println("\n--- LISTA ---");
        for (Pelicula p : lista) {
            System.out.println(p);
        }

        // 🔍 BUSCAR
        System.out.print("\nBuscar pelicula: ");
        String buscar = sc.nextLine();

        boolean encontrada = false;

        // LIST
        for (Pelicula p : lista) {
            if (p.getNombre().equalsIgnoreCase(buscar)) {
                System.out.println("Encontrada en LIST: " + p);
                encontrada = true;
            }
        }

        // SET
        for (Pelicula p : set) {
            if (p.getNombre().equalsIgnoreCase(buscar)) {
                System.out.println("Encontrada en SET: " + p);
                encontrada = true;
            }
        }

        // MAP
        for (String genero : mapa.keySet()) {
            for (Pelicula p : mapa.get(genero)) {
                if (p.getNombre().equalsIgnoreCase(buscar)) {
                    System.out.println("Encontrada en MAP: " + p);
                    encontrada = true;
                }
            }
        }

        if (!encontrada) {
            System.out.println(" Pelicula no encontrada");
        }

        lista.sort(Comparator.comparingInt(p -> p.getDuracion()));
        System.out.println("\n--- Ordenadas por duración ---");
        for (Pelicula p : lista) {
            System.out.println(p);
        }

        TreeSet<Pelicula> tree = new TreeSet<>(Comparator.comparing(p -> p.getNombre()));
        tree.addAll(lista);

        System.out.println("\n--- Ordenadas por nombre ---");
        for (Pelicula p : tree) {
            System.out.println(p);
        }

        sc.close();
    }
}
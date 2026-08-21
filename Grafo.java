import java.util.Scanner;

public class Grafo {
    private int numVertices;
    private String[] vertices;
    private int[][] matrizAdyacencia;
    private Scanner scanner;

    public Grafo() {
        this.scanner = new Scanner(System.in);
    }

    public void agregarVertices() {
        System.out.print("¿Cuántos vértices deseas agregar? ");
        this.numVertices = scanner.nextInt();
        scanner.nextLine();

        this.vertices = new String[numVertices];
        this.matrizAdyacencia = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Ingresa el nombre/valor del vértice " + (i + 1) + ": ");
            vertices[i] = scanner.nextLine();
        }

        System.out.println("\n✓ Vértices agregados correctamente.\n");
    }

    public void insertarRelaciones() {
        if (numVertices == 0) {
            System.out.println("Error: Primero debes agregar vértices.");
            return;
        }

        System.out.println("Ingresa las relaciones entre vértices (Grafo No Dirigido).");
        System.out.println("(Ingresa 1 si hay relación, 0 si no)\n");

        // Grafo no dirigido: solo preguntar por pares i < j
        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                System.out.print("¿Relación entre " + vertices[i] + " y " + vertices[j] + "? (0/1): ");
                int relacion = scanner.nextInt();
                matrizAdyacencia[i][j] = (relacion == 1) ? 1 : 0;
                matrizAdyacencia[j][i] = (relacion == 1) ? 1 : 0;
            }
        }

        scanner.nextLine(); 
        System.out.println("\nRelaciones insertadas correctamente.\n");

    }

    public void generarMatrizRelaciones() {
        if (numVertices == 0) {
            System.out.println("Error: No hay vértices en el grafo.");
            return;
        }

        System.out.println("MATRIZ DE ADYACENCIA\n");

         System.out.print("     ");
        for (String vertice : vertices) {
            System.out.print(String.format("%6s", vertice));
        }
        System.out.println();

         for (int i = 0; i < numVertices; i++) {
            System.out.print(String.format("%5s", vertices[i]));
            for (int j = 0; j < numVertices; j++) {
                System.out.print(String.format("%6d", matrizAdyacencia[i][j]));
            }
            System.out.println();
        }
        System.out.println();
    }

    public int[][] obtenerMatriz() {
        return matrizAdyacencia;
    }

    public String[] obtenerVertices() {
        return vertices;
    }

    public int obtenerNumVertices() {
        return numVertices;
    }
}

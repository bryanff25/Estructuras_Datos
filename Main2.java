public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        
        System.out.println("=== AGREGAR VÉRTICES ===");
        grafo.agregarVertices();

        
        System.out.println("=== INSERTAR RELACIONES ===");
        grafo.insertarRelaciones();

        
        System.out.println("=== RESULTADO FINAL ===");
        grafo.generarMatrizRelaciones();
    }
}

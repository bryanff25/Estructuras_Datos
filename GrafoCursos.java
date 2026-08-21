import java.util.*;

public class GrafoCursos {
    private Map<Integer, List<Integer>> adjacencia = new HashMap<>();

    public void agregarCurso(int idCurso) {
        adjacencia.putIfAbsent(idCurso, new ArrayList<>());
    }

    public void agregarPrerrequisito(int idOrigen, int idDestino) {
        if (adjacencia.containsKey(idOrigen) && adjacencia.containsKey(idDestino)) {
            adjacencia.get(idOrigen).add(idDestino);
        } else {
            System.out.println("Error: Uno o ambos cursos no existen en el grafo.");
        }
    }

    public void mostrarGrafo() {
        for (var entry : adjacencia.entrySet()) {
            System.out.println("Curso ID " + entry.getKey() + " es prerrequisito de: " + entry.getValue());
        }
    }
}

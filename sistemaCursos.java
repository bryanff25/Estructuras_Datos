import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class sistemaCursos {
    // Estructuras de datos solicitadas
    private static ArrayList<Curso> listaCursos = new ArrayList<>();
    private static Stack<String> historialAcciones = new Stack<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
                int opcion = 0;


do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    agregarCurso();
                    break;
                case 2:
                    mostrarCursos();
                    break;
                case 3:
                    buscarCursoPorClave();
                    break;
                case 4:
                    inscribirEstudiante();
                    break;
                case 5:
                    darDeBajaEstudiante();
                    break;
                case 6:
                    eliminarCurso();
                    break;
                case 7:
                    mostrarHistorial();
                    break;
                case 8:
                    // Funcionalidad Adicional Obligatoria (Filtro/Ordenamiento)
                    ordenarCursosPorNombre();
                    break;
                case 9:
                    System.out.println("Saliendo del sistema... ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
            System.out.println(); // Salto de línea estético
        } while (opcion != 9);
    }

private static void mostrarMenu() {
        System.out.println("=== SISTEMA DE GESTIÓN DE CURSOS UTC ===");
        System.out.println("1. Agregar curso");
        System.out.println("2. Mostrar cursos");
        System.out.println("3. Buscar curso por clave");
        System.out.println("4. Inscribir estudiante");
        System.out.println("5. Dar de baja estudiante");
        System.out.println("6. Eliminar curso");
        System.out.println("7. Mostrar historial de acciones (Pila)");
        System.out.println("8. [EXTRA] Ordenar cursos por nombre alfabéticamente");
        System.out.println("9. Salir");
    }

private static void agregarCurso() {
        System.out.print("Ingrese la clave del curso: ");
        String clave = scanner.nextLine();

if (buscarCurso(clave) != null) {
            System.out.println("Error: Ya existe un curso con esa clave.");
            return;
        }

System.out.print("Ingrese el nombre del curso: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el nombre del docente: ");
        String docente = scanner.nextLine();
        System.out.print("Ingrese el cupo máximo: ");
        int cupo = Integer.parseInt(scanner.nextLine());

        Curso nuevoCurso = new Curso(clave, nombre, docente, cupo);
        listaCursos.add(nuevoCurso);

        // Registro en la Pila (Historial)
        historialAcciones.push("Se agregó el curso " + nombre);
        System.out.println("¡Curso agregado con éxito!");
    }

private static void mostrarCursos() {
        if (listaCursos.isEmpty()) {
            System.out.println("No hay cursos registrados en el sistema.");
            return;
        }
        System.out.println("--- LISTA DE CURSOS ---");
        for (Curso c : listaCursos) {
            System.out.println(c);
        }
    }

private static void buscarCursoPorClave() {
        System.out.print("Ingrese la clave del curso a buscar: ");
        String clave = scanner.nextLine();
        Curso curso = buscarCurso(clave);

        if (curso != null) {
            System.out.println("Curso encontrado: " + curso);
        } else {
            System.out.println("Curso no encontrado.");
        }
    }

private static void inscribirEstudiante() {
        System.out.print("Ingrese la clave del curso: ");
        String clave = scanner.nextLine();
        Curso curso = buscarCurso(clave);

        if (curso != null) {
            if (curso.inscribirEstudiante()) {
                historialAcciones.push("Se inscribió un estudiante en " + curso.getNombre());
                System.out.println("Estudiante inscrito exitosamente.");
            } else {
                System.out.println("Error: El curso ha alcanzado su cupo máximo.");
            }
        } else {
            System.out.println("Curso no encontrado.");
        }
    }

private static void darDeBajaEstudiante() {
        System.out.print("Ingrese la clave del curso: ");
        String clave = scanner.nextLine();
        Curso curso = buscarCurso(clave);

        if (curso != null) {
            if (curso.darDeBajaEstudiante()) {
                historialAcciones.push("Se eliminó un estudiante de " + curso.getNombre());
                System.out.println("Estudiante dado de baja con éxito.");
            } else {
                System.out.println("Error: No hay estudiantes inscritos en este curso.");
            }
        } else {
            System.out.println("Curso no encontrado.");
        }
    }

private static void eliminarCurso() {
        System.out.print("Ingrese la clave del curso a eliminar: ");
        String clave = scanner.nextLine();
        Curso curso = buscarCurso(clave);

        if (curso != null) {
            listaCursos.remove(curso);
            historialAcciones.push("Se eliminó el curso " + curso.getNombre());
            System.out.println("Curso eliminado del sistema.");
        } else {
            System.out.println("Curso no encontrado.");
        }
    }

private static void mostrarHistorial() {
        if (historialAcciones.isEmpty()) {
            System.out.println("El historial está vacío.");
            return;
        }
        System.out.println("--- HISTORIAL DE ACCIONES (PILA) ---");
        // Clonamos la pila para mostrar el contenido sin vaciar la estructura original
        Stack<String> tempStack = (Stack<String>) historialAcciones.clone();
        while (!tempStack.isEmpty()) {
            System.out.println("- " + tempStack.pop());
        }
    }

private static void ordenarCursosPorNombre() {
        if (listaCursos.isEmpty()) {
            System.out.println("No hay cursos para ordenar.");
            return;
        }
        // Uso de expresiones Lambda para ordenar la lista sin modificar el orden de inserción original permanentemente
        ArrayList<Curso> copiaOrdenada = new ArrayList<>(listaCursos);
        copiaOrdenada.sort(Comparator.comparing(Curso::getNombre));
        
        System.out.println("--- CURSOS ORDENADOS ALFABÉTICAMENTE ---");
        for (Curso c : copiaOrdenada) {
            System.out.println(c);
        }
    }

private static Curso buscarCurso(String clave) {
        for (Curso c : listaCursos) {
            if (c.getClave().equalsIgnoreCase(clave)) {
                return c;
            }
        }
        return null;
    }
}
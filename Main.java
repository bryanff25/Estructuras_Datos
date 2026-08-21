import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    private static List<Curso> listaCursos = new ArrayList<>();
    private static ArbolCursos arbolBST = new ArbolCursos();
    private static GrafoCursos grafoCursos = new GrafoCursos();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        cargarDatosSemilla();
        int opcion;

        do {
            System.out.println("\n==================================================");
            System.out.println("   SISTEMA DE GESTIÓN DE CURSOS UTC - VERSIÓN 3.0  ");
            System.out.println("==================================================");
            System.out.println("1. Registrar nuevo curso");
            System.out.println("2. Módulo Árbol Binario de Búsqueda (BST)");
            System.out.println("3. Módulo de Grafos (Prerrequisitos)");
            System.out.println("4. Módulo de Métodos de Ordenamiento");
            System.out.println("5. Mostrar lista general de cursos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leerEntero();

            switch (opcion) {
                case 1 -> registrarCurso();
                case 2 -> menuArbol();
                case 3 -> menuGrafo();
                case 4 -> menuOrdenamiento();
                case 5 -> mostrarListaGeneral();
                case 0 -> System.out.println("\n¡Gracias por utilizar el sistema UTC!");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    private static void cargarDatosSemilla() {
        Curso c1 = new Curso(101, "INF101", "Estructura de Datos", "Ing. Morales", 30, 25);
        Curso c2 = new Curso(102, "INF102", "Programación Orientada a Objetos", "Ing. Cruz", 35, 30);
        Curso c3 = new Curso(103, "INF201", "Bases de Datos", "Dra. Hernández", 25, 20);
        Curso c4 = new Curso(104, "INF301", "Sistemas Operativos", "Mtro. Gómez", 30, 15);

        List.of(c1, c2, c3, c4).forEach(c -> {
            listaCursos.add(c);
            arbolBST.insertar(c);
            grafoCursos.agregarCurso(c.getIdCurso());
        });

        grafoCursos.agregarPrerrequisito(102, 101);
        grafoCursos.agregarPrerrequisito(101, 103);
    }

    private static void registrarCurso() {
        System.out.println("\n--- REGISTRO DE NUEVO CURSO ---");
        System.out.print("ID numérico único: ");
        int id = leerEntero();
        System.out.print("Clave: ");
        String clave = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Docente: ");
        String docente = scanner.nextLine();
        System.out.print("Cupo máximo: ");
        int cupo = leerEntero();
        System.out.print("Número de inscritos: ");
        int inscritos = leerEntero();

        Curso nuevo = new Curso(id, clave, nombre, docente, cupo, inscritos);
        listaCursos.add(nuevo);
        arbolBST.insertar(nuevo);
        grafoCursos.agregarCurso(id);

        System.out.println("✓ Curso registrado e integrado a todas las estructuras con éxito.");
    }

    private static void menuArbol() {
        System.out.println("\n--- MÓDULO ÁRBOL BINARIO DE BÚSQUEDA ---");
        System.out.println("1. Buscar curso por ID");
        System.out.println("2. Mostrar recorrido Inorden (Ordenado por ID)");
        System.out.print("Seleccione: ");
        int op = leerEntero();

        if (op == 1) {
            System.out.print("Ingrese ID a buscar: ");
            int id = leerEntero();
            Curso res = arbolBST.buscar(id);
            if (res != null) {
                System.out.println("Encontrado en Árbol: " + res);
            } else {
                System.out.println("Curso no encontrado en el árbol.");
            }
        } else if (op == 2) {
            System.out.println("\nRecorrido Inorden:");
            arbolBST.recorridoInorden();
        }
    }

    private static void menuGrafo() {
        System.out.println("\n--- MÓDULO GRAFO DE PRERREQUISITOS ---");
        System.out.println("1. Relacionar prerrequisito (Curso A -> Curso B)");
        System.out.println("2. Ver grafo de relaciones");
        System.out.print("Seleccione: ");
        int op = leerEntero();

        if (op == 1) {
            System.out.print("ID Curso Prerrequisito (Origen): ");
            int origen = leerEntero();
            System.out.print("ID Curso Dependiente (Destino): ");
            int destino = leerEntero();
            grafoCursos.agregarPrerrequisito(origen, destino);
            System.out.println("✓ Relación registrada en el grafo.");
        } else if (op == 2) {
            System.out.println("\nEstructura del Grafo (Lista de Adyacencia):");
            grafoCursos.mostrarGrafo();
        }
    }

    private static void menuOrdenamiento() {
        System.out.println("\n--- MÓDULO MÉTODOS DE ORDENAMIENTO ---");
        System.out.println("1. Bubble Sort directo (por ID ascendente)");
        System.out.println("2. Bubble Sort inverso (por ID descendente)");
        System.out.println("3. Inserción directa (por Nombre alfabético)");
        System.out.println("4. Selección directa (por Inscritos ascendente)");
        System.out.print("Seleccione el método a probar: ");
        int op = leerEntero();

        List<Curso> copia = new ArrayList<>(listaCursos);

        switch (op) {
            case 1 -> {
                AlgoritmosOrdenamiento.bubbleSortDirecto(copia);
                System.out.println("\nOrdenado con Bubble Sort Directo:");
            }
            case 2 -> {
                AlgoritmosOrdenamiento.bubbleSortInverso(copia);
                System.out.println("\nOrdenado con Bubble Sort Inverso:");
            }
            case 3 -> {
                AlgoritmosOrdenamiento.insercionDirecta(copia);
                System.out.println("\nOrdenado con Inserción Directa:");
            }
            case 4 -> {
                AlgoritmosOrdenamiento.seleccionDirecta(copia);
                System.out.println("\nOrdenado con Selección Directa:");
            }
            default -> {
                System.out.println("Opción no válida.");
                return;
            }
        }
        copia.forEach(System.out::println);
    }

    private static void mostrarListaGeneral() {
        System.out.println("\n--- LISTA GENERAL DE CURSOS ---");
        listaCursos.forEach(System.out::println);
    }

    private static int leerEntero() {
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor ingrese un número entero válido: ");
            scanner.next();
        }
        int num = scanner.nextInt();
        scanner.nextLine();
        return num;
    }
}

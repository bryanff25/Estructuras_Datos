import java.util.Scanner;

public class MenuListaEnlazada {
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        int valor;

        do {
            System.out.println("\n=== MENÚ LISTA ENLAZADA ===");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Mostrar lista");
            System.out.println("4. Eliminar un elemento");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, introduce un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el valor a insertar al inicio: ");
                    valor = scanner.nextInt();
                    lista.insertarInicio(valor);
                    break;
                case 2:
                    System.out.print("Ingrese el valor a insertar al final: ");
                    valor = scanner.nextInt();
                    lista.insertarFinal(valor);
                    break;
                case 3:
                    lista.mostrarLista();
                    break;
                case 4:
                    System.out.print("Ingrese el valor del elemento a eliminar: ");
                    valor = scanner.nextInt();
                    lista.eliminarElemento(valor);
                    break;
                case 5:
                    System.out.println("Saliendo del programa... ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}

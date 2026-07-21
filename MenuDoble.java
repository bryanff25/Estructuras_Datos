import java.util.Scanner;

public class MenuDoble {
    public static void main(String[] args) {
        ListaDobleEnlazada lista = new ListaDobleEnlazada();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        int valor;

        do {
            System.out.println("\nMENÚ LISTA DOBLE ENLAZADA");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Mostrar de inicio a fin");
            System.out.println("4. Mostrar de fin a inicio");
            System.out.println("5. Eliminar un Dato");
            System.out.println("6. Salir");
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
                    lista.mostrarAdelante();
                    break;
                case 4:
                    lista.mostrarAtras();
                    break;
                case 5:
                    System.out.print("Ingrese el valor del elemento a eliminar: ");
                    valor = scanner.nextInt();
                    lista.eliminarElemento(valor);
                    break;
                case 6:
                    System.out.println("Saliendo del programa... ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}

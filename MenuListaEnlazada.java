import java.util.Scanner;

public class MenuListaEnlazada {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();

        int opcion;
        String dato, nuevoDato;

        do {
            System.out.println("\n");
            System.out.println("   LISTA ENLAZADA   ");
            System.out.println("");
            System.out.println("1. Agregar nodo");
            System.out.println("2. Mostrar lista");
            System.out.println("3. Buscar nodo");
            System.out.println("4. Actualizar nodo");
            System.out.println("5. Eliminar nodo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = entrada.nextInt();
            entrada.nextLine(); // Limpiar buffer

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese el dato a agregar: ");
                    dato = entrada.nextLine();
                    lista.agregarFinal(dato);
                    System.out.println("Nodo agregado correctamente.");
                    break;

                case 2:
                    System.out.println("\n      LISTA      ");
                    lista.recorrido();
                    break;

                case 3:
                    System.out.print("Ingrese el dato a buscar: ");
                    dato = entrada.nextLine();
                    lista.buscar(dato);
                    break;

                case 4:
                    System.out.print("Ingrese el dato que desea actualizar: ");
                    dato = entrada.nextLine();

                    System.out.print("Ingrese el nuevo dato: ");
                    nuevoDato = entrada.nextLine();

                    lista.actualizar(dato, nuevoDato);
                    break;

                case 5:
                    System.out.print("Ingrese el dato que desea eliminar: ");
                    dato = entrada.nextLine();
                    lista.eliminar(dato);
                    break;

                case 6:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 6);

        entrada.close();
    }
}

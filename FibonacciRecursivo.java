import java.util.Scanner;

public class FibonacciRecursivo {

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de términos: ");
        int n = teclado.nextInt();

        int suma = 0;

        System.out.println("Sucesión de Fibonacci:");

        for (int i = 0; i < n; i++) {
            int resultado = fibonacci(i);
            System.out.print(resultado + " ");
            suma = suma + resultado;
        }

        System.out.println();
        System.out.println("La suma es: " + suma);

        teclado.close();
    }
}

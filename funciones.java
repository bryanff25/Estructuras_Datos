public class funciones {
    public static void saludar(){
        System.out.println("¡Hola amigo Chris!");
  
        
}
 public static int calcularfactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El número debe ser un entero positivo.");
        }
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i; 
        }
        return factorial;
    }
    public static double CalcularIVA(double cantidadSinIva, double porcentajeIva) {
        double totalIva = cantidadSinIva * (porcentajeIva / 100.0);
        return cantidadSinIva + totalIva;
    }


    public static double CalcularIVA(double cantidadSinIva) {
        return CalcularIVA(cantidadSinIva, 21.0);
    }
    public static double calcularAreaCirculo(double radio) {
        
        return Math.PI * Math.pow(radio, 2);
    }

    
    public static double calcularVolumenCilindro(double radio, double altura) {
        
        double areaBase = calcularAreaCirculo(radio); 
        return areaBase * altura;
    }
}

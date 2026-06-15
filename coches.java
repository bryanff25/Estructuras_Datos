public class coches {
    public static void main(String[] args) {
        
        
        String[] autos = new String[3];
        
        
        autos[0] = "Toyota";
        autos[1] = "Honda";
        autos[2] = "Ford";
        
       
        System.out.println("El primer auto es: " + autos[0]); 
        System.out.println("---------------------------------");
        
        
        System.out.println("Lista completa de autos:");
        for (int i = 0; i < autos.length; i++) {
            System.out.println("Índice " + i + ": " + autos[i]);
        }
    }
}
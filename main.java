public class Main {
    public static void main(String[] args) {
        
        Nodo raiz = new Nodo(50);

        
        raiz.izquierdo = new Nodo(30);
 
        raiz.derecho = new Nodo(70);

        raiz.izquierdo.izquierdo = new Nodo(20);
        raiz.izquierdo.derecho = new Nodo(40);

        raiz.derecho.izquierdo = new Nodo(60);
        raiz.derecho.derecho = new Nodo(80);

        
        System.out.println("Raíz: " + raiz.valor);                     
        System.out.println("Lado izquierdo: " + raiz.izquierdo.valor); 
        System.out.println("Lado derecho: " + raiz.derecho.valor); 
        System.out.println("Lado izquierdo del izquierdo: " + raiz.izquierdo.izquierdo.valor); 
        System.out.println("Lado derecho del derecho: " + raiz.izquierdo.derecho.valor); 
        System.out.println("Lado izquierdo pero derecho: " + raiz.derecho.izquierdo.valor); 
        System.out.println("Lado derecho pero izquierdo: " + raiz.derecho.derecho.valor);
   
    }
}

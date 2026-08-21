class ArbolBinario {
    Nodo raiz;

    
    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    
    private Nodo insertarRec(Nodo actual, int valor) {
        if (actual == null) {
            return new Nodo(valor); // Crea el nuevo nodo cuando llega a una posición vacía
        }

        if (valor < actual.valor) {
            actual.izquierdo = insertarRec(actual.izquierdo, valor);
        } else if (valor > actual.valor) {
            actual.derecho = insertarRec(actual.derecho, valor);
        }

        return actual;
    }

    
    public void inorden(Nodo nodo) {
        if (nodo != null) {
            inorden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inorden(nodo.derecho);
        }
    }
}

public class EjemploCompleto {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();

       
        int[] valores = {50, 30, 70, 20, 40};
        for (int v : valores) {
            arbol.insertar(v);
        }

        System.out.print("Recorrido Inorden: ");
        arbol.inorden(arbol.raiz); 
    }
}

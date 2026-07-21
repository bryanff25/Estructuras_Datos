public class ListaDobleEnlazada {
    private NodoDoble cabeza;
    private NodoDoble cola;

    public ListaDobleEnlazada() {
        this.cabeza = null;
        this.cola = null;
    }

    
    public void insertarInicio(int dato) {
        NodoDoble nuevo = new NodoDoble(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        }
        System.out.println("Elemento " + dato + " insertado al inicio.");
    }

    
    public void insertarFinal(int dato) {
        NodoDoble nuevo = new NodoDoble(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
        System.out.println("Elemento " + dato + " insertado al final.");
    }

    
    public void mostrarAdelante() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        NodoDoble temporal = cabeza;
        System.out.print("Lista (inicio a fin): null <-> ");
        while (temporal != null) {
            System.out.print("[" + temporal.dato + "] <-> ");
            temporal = temporal.siguiente;
        }
        System.out.println("null");
    }

    
    public void mostrarAtras() {
        if (cola == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        NodoDoble temporal = cola;
        System.out.print("Lista (fin a inicio): null <-> ");
        while (temporal != null) {
            System.out.print("[" + temporal.dato + "] <-> ");
            temporal = temporal.anterior;
        }
        System.out.println("null");
    }

    
    public void eliminarElemento(int dato) {
        if (cabeza == null) {
            System.out.println("La lista está vacía, nada que eliminar.");
            return;
        }

        NodoDoble actual = cabeza;

        
        while (actual != null && actual.dato != dato) {
            actual = actual.siguiente;
        }

        
        if (actual == null) {
            System.out.println("El elemento " + dato + " no se encontró en la lista.");
            return;
        }

        
        if (actual == cabeza && actual == cola) {
            cabeza = null;
            cola = null;
        }
        
        else if (actual == cabeza) {
            cabeza = cabeza.siguiente;
            cabeza.anterior = null;
        }
        
        else if (actual == cola) {
            cola = cola.anterior;
            cola.siguiente = null;
        }
        
        else {
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;
        }

        System.out.println("Elemento " + dato + " eliminado.");
    }
}

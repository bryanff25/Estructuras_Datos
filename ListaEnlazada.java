public class ListaEnlazada {
    Nodo cabeza;

    public void agregarNodoInicio(String datoNodo){
        Nodo nuevo = new Nodo(datoNodo);
        nuevo.siguienteNodo = cabeza;
        cabeza = nuevo;
    }
    public void recorrido(){
        Nodo actual = cabeza;
        while (actual != null){
            System.out.println(actual.Dato);
            actual = actual.siguienteNodo;
        }
    }
    public void agregarFinal(String datoNodo){
        Nodo nuevo = new Nodo(datoNodo);
        if (cabeza == null){
            cabeza = nuevo;
            return;
        }
        Nodo actual = cabeza;
        while(actual.siguienteNodo != null){
            actual = actual.siguienteNodo;
        }
        actual.siguienteNodo = nuevo;
    }
    public boolean eliminarNodo(String datoEliminar){
        if (cabeza == null){
            return false;
        }
        Nodo actual = cabeza;
        while (actual.siguienteNodo != null){
            if(actual.siguienteNodo.Dato.equals(datoEliminar)){
                actual.siguienteNodo = actual.siguienteNodo.siguienteNodo;
                return true;
            }
            actual = actual.siguienteNodo;
        }
        return false;
    }
}

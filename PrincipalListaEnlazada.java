public class PrincipalListaEnlazada {
    static void main(){
        ListaEnlazada();
        lista.agregarNodoInicio("E");
        lista.agregarNodoInicio("D");
        lista.agregarNodoInicio("C");
        lista.agregarNodoInicio("B");
        lista.agregarNodoInicio("A");
        lista.recorrido();
        lista.agregarFinal("X");
        lista.recorrido();
        lista.eliminarNodo("D");
        lista.recorrido();
    }
}

public class ListaEnlazadaBasica {
	public static void main(String[] args) {
		Nodo n1 = new Nodo("A");
		Nodo n2 = new Nodo("B");
		Nodo cabeza = n1;
		n1.siguienteNodo = n2;
		Nodo n3 = new Nodo("C");
		n2.siguienteNodo = n3;	
		Nodo n4 = new Nodo("D");
		n3.siguienteNodo = n4;
		Nodo n5 = new Nodo("E");
		System.out.println("El primer nodo contiene el dato A y el siguiente nodo es B");
		System.out.println("El primer nodo contiene el dato C y el siguiente nodo es D");
	}
}

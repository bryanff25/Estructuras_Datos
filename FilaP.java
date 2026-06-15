import java.util.Queue;
import java.util.LinkedList;

public class FilaP{
    public static void main(String[] args) {
        Queue<String> cola = new LinkedList<>();
        cola.add("Pablo");
        cola.add("Laura");
        cola.add("Alejandro");
        cola.add("Omar");
        cola.add("Martha");

        System.out.println("Cola actual: " + cola);

        System.out.println("Persona hasta en frente:" + cola.peek());

        for(int i=0;i<2;i++){
            cola.poll();

        }

        System.out.println("Cola restante: " + cola);
    }
}

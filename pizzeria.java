public class pizzeria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ing = "Mozzarella, Tomate";

        System.out.print("Pizza (1.Veg / 2.No Veg): ");
        String tipo = sc.nextLine();

        if (tipo.equals("1")) {
            System.out.print("Ingrediente (a.Pimiento / b.Tofu): ");
            String op = sc.nextLine();
            ing += (op.equals("a")) ? ", Pimiento" : (op.equals("b")) ? ", Tofu" : " (Inválido)";
            System.out.println("\nTipo: Vegetariana\nIngredientes: " + ing);
        } else if (tipo.equals("2")) {
            System.out.print("Ingrediente (a.Peperoni / b.Jamón / c.Salmón): ");
            String op = sc.nextLine();
            ing += (op.equals("a")) ? ", Peperoni" : (op.equals("b")) ? ", Jamón" : (op.equals("c")) ? ", Salmón" : " (Inválido)";
            System.out.println("\nTipo: No vegetariana\nIngredientes: " + ing);
        } else {
            System.out.println("Opción inválida.");
        }
        sc.close();
    }
}

public class Perro{
	private String nombre;
	private String raza;
	private int edad;

	
	public Perro(String nombre, String raza, int edad){
	this.nombre = nombre;
	this.raza = raza;
	this.edad = edad;
}

	public void ladrar() {
        System.out.println(this.nombre + " y como dice mi perro: ¡GUAU, GUAU!");
    }

    public void presentarse(){
        System.out.println("Hola mi perro se llama " + this.nombre + " es de raza " + this.raza + " y tiene " + this.edad + " años " );
    }
    public static void main(String[] args){
        Perro miPerro = new Perro ("MAXIMUS","PITBULL", 3);
        miPerro.presentarse();
        miPerro.ladrar();
    }

}

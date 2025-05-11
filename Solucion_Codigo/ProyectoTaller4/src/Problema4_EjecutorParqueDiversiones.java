
import java.util.Scanner;


public class Problema4_EjecutorParqueDiversiones {
    public static Juego juego1 = new Juego ("Montaña Rusa", 15, 155);
    public static Juego juego2 = new Juego ("Casa del terror", 18, 160);
    public static Juego juego3 = new Juego ("El Martillo", 14, 160);
    public static Juego juego4 = new Juego ("Picina de pelotas", 5, 100);
    public static Scanner sc = new Scanner(System.in);
    public static void main (String args[] ) {
        
       
        int edades[] = {22, 18, 16, 20, 21, 12, 10, 8, 9, 10};
        int altura [] = {100, 120, 125, 140, 145, 160, 178, 175, 180, 186};
        String personasconAc = "";
        char opcion = 'S';
        int seleccion;
        Juego juegoSeleccionado;
        while (opcion == 'S') {
            int edadVis = edades[(int) Math.floor(Math.random() * edades.length)];
            int alturaVis = altura[(int) Math.floor(Math.random() * altura.length)];
            System.out.println("Seleccion el juego que desea ");
            do  {
                System.out.println("1) Montaña Rusa");
                System.out.println("2) Casa del terror");
                System.out.println("3) El Martillo");
                System.out.println("4) Picina de Pelotas");
                seleccion = sc.nextInt();
            }while (seleccion < 1 || seleccion > 4);
           switch (seleccion) {
                case 1:
                    juegoSeleccionado = juego1;
                    break;
                case 2:
                    juegoSeleccionado = juego2;
                    break;
                case 3:
                    juegoSeleccionado = juego3;
                    break;
                case 4:
                    juegoSeleccionado = juego4;
                    break;
                default:
                    System.out.println("Selección no válida.");
                    continue; 
            }
            Visitante visitante = new Visitante (edadVis, alturaVis,juegoSeleccionado );
            if (visitante.conocerAcceso()) {
                personasconAc += visitante.toString() + "\n";
            } 
            System.out.println("Visitante generado: " + visitante);
            System.out.print("¿Desea ingresar otro visitante(S/N)?: ");
            opcion = sc.next().charAt(0);
        }
        
        System.out.println("La cantidad de personas con acceso a los juegos fueron :" + personasconAc);
        
        

    }

}

class Juego {

    public String nombre;
    public int edadMinima;
    public int alturaMinima;

    public Juego() {}

    public Juego(String nombre, int edadMinima, int alturaMinima) {

        this.nombre = nombre;
        this.edadMinima = edadMinima;
        this.alturaMinima = alturaMinima;
    }


    @Override
    public String toString() {
        return "Juego{" + "nombre=" + nombre + ", edadminima=" + edadMinima + ", alturaminima=" + alturaMinima + '}';
    }
    

}

class Visitante {

    public int edad;
    public int altura;
    public Juego juego;
    public boolean acceso;
    

    public Visitante() {}

    public Visitante( int edad, int altura, Juego juego) {
        this.edad = edad;
        this.altura = altura;
        this.juego = juego;
                
    }
    
    public boolean conocerAcceso () {
        if (this.edad >= juego.edadMinima && this.altura >= juego.alturaMinima) {
            this.acceso = true;
            return this.acceso;
        } else {
            this.acceso = false;
            return this.acceso;
        }
    }

    @Override
    public String toString() {
        return "Visitante{" + "edad=" + edad + ", altura=" + altura + ", juego=" + juego + ", acceso=" + acceso + '}';
    }
    
    
}

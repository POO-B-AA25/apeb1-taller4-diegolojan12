
import java.util.ArrayList;
import java.util.Scanner;

public class Problema5_Gym {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {

        String nombre[] = {"Juan", "Felipe", "Claudio", "Ana", "Rebeca"};
        String apellido[] = {"Fernandez", "Juarez", "Calles", "Díaz", "Claveles"};
        String ejercicio[] = {"Cardio", "Fuerza", "Estiramiento"};
        int duracion[] = {10, 15, 20, 25};
        boolean cumplimiento[] = {true, false};

        ArrayList<Integer> arreglotiempo = new ArrayList<>();
        String cumplieron = "";

        char opcion = 'S';

        while (opcion == 'S' || opcion == 's') {
            String nombreCli = nombre[(int) Math.floor(Math.random() * nombre.length)] + " "
                    + apellido[(int) Math.floor(Math.random() * apellido.length)];
            String ejercicoCli = ejercicio[(int) Math.floor(Math.random() * ejercicio.length)];
            int duracionCli = duracion[(int) Math.floor(Math.random() * duracion.length)];
            boolean cumplimientoCli = cumplimiento[(int) Math.floor(Math.random() * cumplimiento.length)];

            arreglotiempo.add(duracionCli);
            Cliente cliente = new Cliente(nombreCli, ejercicoCli, duracionCli, cumplimientoCli);

            if (cumplimientoCli) {
                cumplieron += cliente.toString() + "\n";
            }

            System.out.println("Cliente generado: " + cliente);
            System.out.print("¿Desea ingresar otro cliente (S/N)?: ");
            opcion = sc.next().charAt(0);
        }

        Gimacio gimnasio = new Gimacio();
        System.out.println("\nCompletaron su rutina:\n" + cumplieron
                + "\nPromedio de tiempo: " + gimnasio.calcularPromedio(arreglotiempo));
    }
}



class Cliente {

    public String nombre;
    public String ejercicio;
    public int duracion;
    public boolean cumplio;

    public Cliente() {
    }

    public Cliente(String nombre, String ejercicio, int duracion, boolean cumplio) {
        this.nombre = nombre;
        this.ejercicio = ejercicio;
        this.duracion = duracion;
        this.cumplio = cumplio;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", ejercicio=" + ejercicio + ", duracion=" + duracion + ", cumplio=" + cumplio + '}';
    }
}

class Gimacio {

    public Cliente cliente;
    public double promedioTiempo;

    public Gimacio() {
    }

    public Gimacio(Cliente cliente) {
        this.cliente = cliente;
    }

    public double calcularPromedio(ArrayList<Integer> tiempos) {
        if (tiempos.isEmpty()) {
            return 0;
        }

        int sumatoria = 0;
        for (int i = 0; i < tiempos.size(); i++) {
            sumatoria += tiempos.get(i);
        }

        this.promedioTiempo = (double) sumatoria / tiempos.size();
        return this.promedioTiempo;
    }

    @Override
    public String toString() {
        return "Gimacio{" + "cliente=" + cliente + '}';
    }
}

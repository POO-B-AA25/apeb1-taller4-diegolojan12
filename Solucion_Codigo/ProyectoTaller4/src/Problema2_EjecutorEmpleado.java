
import java.util.ArrayList;
import java.util.Scanner;

public class Problema2_EjecutorEmpleado {

    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<String> arreglonombres = new ArrayList<>();
    public static ArrayList<Double> arreglosalario = new ArrayList<>();
    public static ArrayList<Integer> arregloage = new ArrayList<>();

    public static void main(String[] args) {

        String nombres[] = {"Orlando", "Felipe", "Claudio", "Ana", "Rebeca"};
        String apellidos[] = {"Dominguez", "Juarez", "Calles", "Marquez", "Claveles"};
        double salarios[] = {450.5, 512.5, 700, 850.5, 950.5};
        int edades[] = {22, 25, 23, 27, 29, 30, 31, 33, 36, 40, 41, 45, 50, 52, 53};
        String empleadosCambioSalario = "";
        char seleccion = 's';
        double sumasalarios;
        int opcion;

        do {
            System.out.println("1. Agregar un empleado");
            System.out.println("2. Mostrar información de los empleados");
            System.out.println("3. Calcular aumento de salario");
            System.out.println("4. salir ");
            System.out.print("Seleccione la opcion que desea: ");
            opcion = sc.nextInt();

            if (opcion < 1 || opcion > 4) {
                System.out.println("Opcion incorrecta vuelva a escoger.");
            }
            switch (opcion) {
                case 1 -> {

                    while (seleccion == 's') {
                        String nombreEm = nombres[(int) Math.floor(Math.random() * nombres.length)] + " " + apellidos[(int) Math.floor(Math.random() * apellidos.length)];
                        double salarioEm = salarios[(int) Math.floor(Math.random() * salarios.length)];
                        int edadEm = edades[(int) Math.floor(Math.random() * edades.length)];
                        arreglonombres.add(nombreEm);
                        arreglosalario.add(salarioEm);
                        arregloage.add(edadEm);
                        Empleado empleado = new Empleado(nombreEm, salarioEm, edadEm);
                        System.out.println("Empleado ingresado: " + empleado.mostrarInformacion());
                        System.out.print("Desea agregar otro empleado? (s/n): ");
                        seleccion = sc.next().charAt(0);
                    }

                }

                case 2 -> {
                    if (arreglonombres.isEmpty()) {
                        System.out.println("No hay empleados registrados.");
                    } else {
                        System.out.println("Información de los empleados:");
                        for (int i = 0; i < arreglonombres.size(); i++) {
                            Empleado empleado = new Empleado(arreglonombres.get(i), arreglosalario.get(i), arregloage.get(i));
                            System.out.println(empleado.mostrarInformacion());
                        }
                    }
                }
                case 3 -> {
                    if (arreglosalario.isEmpty()) {
                        System.out.println("No hay empleados para calcular aumento.");
                    } else {
                        System.out.println("Aumento Salarial");
                        System.out.print("Ingrese el porcentaje de aumento: ");
                        double porcentajedeAumento = sc.nextDouble();
                        sumasalarios = 0;
                        for (int i = 0; i < arreglosalario.size(); i++) {
                            sumasalarios = sumasalarios + arreglosalario.get(i);
                        }
                        double promediosalarios = sumasalarios / arreglosalario.size();
                        for (int i = 0; i < arreglosalario.size(); i++) {
                            if (arreglosalario.get(i) < promediosalarios) {
                                double nuevoSalario = arreglosalario.get(i) + (arreglosalario.get(i) * (porcentajedeAumento / 100));
                                arreglosalario.set(i, nuevoSalario);
                                Empleado empleado = new Empleado(arreglonombres.get(i), nuevoSalario, arregloage.get(i));
                                empleadosCambioSalario += empleado.mostrarInformacion() + "\n";
                            }
                        }
                        System.out.println("Empleados Cambio de salario: \n" +empleadosCambioSalario );
                        
                    }
                }
                
                default -> {
                    System.out.println("Gracias por usar nuestor Programa");
                }
            }
        } while (opcion != 4);

    }

}

class Empleado {

    public String nombre;
    public double salario;
    public int edad;

    public Empleado() {}

    public Empleado(String nombre, double salario, int edad) {
        this.nombre = nombre;
        this.salario = salario;
        this.edad = edad;
    }

    public String mostrarInformacion() {
        return "Empleado{" + "nombre=" + nombre + ", salario=" + salario + ", edad=" + edad + '}';
    }

}

import java.util.Scanner;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Principal.mostrarMenu();
    }

    public static void mostrarMenu() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Ingrese numero");
        System.out.println();
        System.out.println("1:   Crear nuevo Vehiculo");
        System.out.println("2:   Mostrar información de Vehiculos");
        System.out.println("3:   Cantidad de Vehiculos");
        System.out.println("4:   Información de Vehiculos Verdes");
        System.out.println("5:   Crear nuevo Sensor");
        System.out.println("6:   Mostrar información de Sensores");
        System.out.println("7:   Cantidad de Sensores");
        System.out.println("8:   Información de Sensores de Temperatura");
        System.out.println("666:   Sensores de Temperatura ordenados");
        System.out.println("0:   Salir");
        
        int num = scan.nextInt();
        while (true) {
            if (num == 0) {
                System.out.println("Chao");
                break;
            }
            switch (num) {
            case 1:
                if (Vehiculo.cantidadVehiculos() < Vehiculo.tamano) {
                    System.out.println("Ingrese Modelo, Marca, Valor Comercial y Color");
                    new Vehiculo(scan.nextInt(), scan.next(), scan.nextDouble(), scan.next());
                } else {
                    System.out.println("Error: Base de datos llena");
                }
                break;
            case 2:
                System.out.println(Vehiculo.toStringVehiculos());
                break;
            case 3:
                System.out.println("Cantidad de Vehiculos: "+Vehiculo.cantidadVehiculos());
                break;
            case 4:
                for (int i = 0; i < Vehiculo.cantidadVehiculos(); i++) {
                    if (Vehiculo.vehiculos[i].getColor().equals("verde")) {
                        System.out.println(Vehiculo.vehiculos[i].toString());
                    }
                }
                break;
            case 5:
                if (Sensor.cantidadSensores() < Sensor.tamano) {
                    System.out.println("Ingrese Tipo y Valor del Sensor");
                    new Sensor(scan.next(), scan.nextDouble());
                } else {
                    System.out.println("Error: Base de datos llena");
                }
                break;
            case 6:
                System.out.println(Sensor.toStringSensores());
                break;
            case 7:
                System.out.println("Cantidad de Sensores: " + Sensor.cantidadSensores());
                break;
            case 8:
                for (int i = 0; i < Sensor.cantidadSensores(); i++) {
                    if (Sensor.sensores[i].getTipo().equals("temperatura")) {
                        System.out.println(Sensor.sensores[i].toString());
                    }
                }
                break;
            case 666:
                ArrayList<Sensor> TempOrden = Sensor.TemperaturaOrden();
                for (int i = 0; i < TempOrden.size(); i++) {
                    System.out.println(TempOrden.get(i).toString());
                }
                break;
            }
            System.out.println();
            System.out.println("Ingrese numero");
            System.out.println();
            System.out.println("1:   Crear nuevo Vehiculo");
            System.out.println("2:   Mostrar información de Vehiculos");
            System.out.println("3:   Cantidad de Vehiculos");
            System.out.println("4:   Información de Vehiculos Verdes");
            System.out.println("5:   Crear nuevo Sensor");
            System.out.println("6:   Mostrar información de Sensores");
            System.out.println("7:   Cantidad de Sensores");
            System.out.println("8:   Información de Sensores de Temperatura");
            System.out.println("666:   Sensores de Temperatura ordenados");
            System.out.println("0:   Salir");
            num = scan.nextInt();
        }
    }
}
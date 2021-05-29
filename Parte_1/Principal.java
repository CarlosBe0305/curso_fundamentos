package Parte_1;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

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
        System.out.println("5:   Mostrar información de Vehiculo por id");
        System.out.println("6:   Crear nuevo Sensor por id de Vehiculo");
        System.out.println("7:   Mostrar Sensores por id de Vehiculo");
        System.out.println("8:   Información de Sensores de Temperatura");
        System.out.println("9:   Información de Vehiculo con más sensores");
        System.out.println("10:   Leer archivo .txt");
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
                    System.out.println("Ingrese Modelo, Marca, Valor Comercial y Color");
                    new Vehiculo(scan.nextInt(), scan.next(), scan.nextDouble(), scan.next());
                    break;
                case 2:
                    System.out.println(Vehiculo.toStringVehiculos());
                    break;
                case 3:
                    System.out.println("Cantidad de Vehiculos: " + Vehiculo.cantidadVehiculos());
                    break;
                case 4:
                    System.out.println("Vehiculos verdes");
                    Principal.verdes();
                    break;
                case 5:
                    System.out.println("ingrese id");
                    int id = scan.nextInt();
                    try {
                        System.out.println(Vehiculo.vehiculos.get(id).toString());
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Error: El vehiculo no existe");
                    }
                    break;
                case 6:
                    System.out.println("ingrese id");
                    int id2 = scan.nextInt();
                    try {
                        Vehiculo.obtenerVehiculoPorId(id2).anadirSensor(new Sensor(scan.next(), scan.nextDouble()));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Error: El vehiculo no existe");
                    }
                    /* System.out.println(Sensor.toStringSensores()); */
                    break;
                case 7:
                    System.out.println("ingrese id");
                    int id3 = scan.nextInt();
                    try {
                        Vehiculo v = Vehiculo.obtenerVehiculoPorId(id3);
                        for (int i = 0; i < v.cantidadSensores(); i++) {
                            System.out.println(v.getSensores().get(i).toString());
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Error: El vehiculo no existe");
                    }
                    break;
                case 8:
                    Principal.temperatura();
                    break;
                case 9:
                    System.out.println(Principal.masSensores());
                    break;
                case 10:
                    Principal.leerDatos();
                    break;
                case 666:
                    ArrayList<Sensor> TempOrden = Principal.TemperaturaOrden();
                    for (int i = 0; i < TempOrden.size(); i++) {
                        System.out.println(TempOrden.get(i).toString());
                    }
                    break;
            }
            System.out.println("Ingrese numero");
            System.out.println();
            System.out.println("1:   Crear nuevo Vehiculo");
            System.out.println("2:   Mostrar información de Vehiculos");
            System.out.println("3:   Cantidad de Vehiculos");
            System.out.println("4:   Información de Vehiculos Verdes");
            System.out.println("5:   Mostrar información de Vehiculo por id");
            System.out.println("6:   Crear nuevo Sensor por id de Vehiculo");
            System.out.println("7:   Mostrar Sensores por id de Vehiculo");
            System.out.println("8:   Información de Sensores de Temperatura");
            System.out.println("9:   Información de Vehiculo con más sensores");
            System.out.println("10:   Leer archivo .txt");
            System.out.println("666:   Sensores de Temperatura ordenados");
            System.out.println("0:   Salir");
            num = scan.nextInt();
        }
    }

    public static void verdes() {
        for (int i = 0; i < Vehiculo.cantidadVehiculos(); i++) {
            if (Vehiculo.vehiculos.get(i).getColor().equals("verde")) {
                System.out.println(Vehiculo.vehiculos.get(i).toString());
            }
        }
    }

    public static void temperatura() {
        for (int i = 0; i < Vehiculo.cantidadVehiculos(); i++) {
            Vehiculo v = Vehiculo.vehiculos.get(i);
            for (int j = 0; j < v.cantidadSensores(); j++) {
                if (v.getSensores().get(j).getTipo().equals("temperatura")) {
                    System.out.println(v.getSensores().get(j).toString());
                }
            }
        }
    }

    public static String masSensores() {
        String mas = "";
        int temporal = 0;
        for (int i = 0; i < Vehiculo.cantidadVehiculos(); i++) {
            if (Vehiculo.vehiculos.get(i).cantidadSensores() > temporal) {
                temporal = Vehiculo.vehiculos.get(i).cantidadSensores();
                mas = Vehiculo.vehiculos.get(i).toString();
            }
        }
        return mas;
    }

    public static ArrayList<Sensor> TemperaturaOrden() {
        ArrayList<Sensor> tempOrden = new ArrayList<Sensor>();
        for (int i = 0; i < Vehiculo.cantidadVehiculos(); i++) {
            Vehiculo v = Vehiculo.vehiculos.get(i);
            for (int j = 0; j < v.cantidadSensores(); j++) {
                if (Vehiculo.vehiculos.get(i).getSensores().get(j).getTipo().equals("temperatura")) {
                    tempOrden.add(Vehiculo.vehiculos.get(i).getSensores().get(j));
                }
            }
        }
        for (int i = 0; i < tempOrden.size() - 1; i++) {
            int pos_menor = i;
            for (int j = i + 1; j < tempOrden.size(); j++) {
                if (tempOrden.get(j).getValor() < tempOrden.get(pos_menor).getValor()) {
                    pos_menor = j;
                }
            }
            Sensor temp = tempOrden.get(i);
            tempOrden.set(i, tempOrden.get(pos_menor));
            tempOrden.set(pos_menor, temp);
        }
        return tempOrden;
    }

    public static void leerDatos() {
        try {
            File file = new File("Vehiculo.txt");
            Scanner scan = new Scanner(file);
            String line = "";
            int modeloInteger = 0;
            double valorDouble = 0;
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                System.out.println(line);
                String[] parts = line.split(", ");
                String modelo = parts[0];
                modeloInteger = new Integer(modelo);
                String marca = parts[1];
                String valorComercial = parts[2];
                valorDouble = new Double(valorComercial);
                String color = parts[3];
                new Vehiculo(modeloInteger, marca, valorDouble, color);
            }
        } catch (Exception e) {
        }

    }
}
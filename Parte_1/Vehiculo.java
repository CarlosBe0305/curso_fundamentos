package Parte_1;
import java.util.ArrayList;

public class Vehiculo {
    public static ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

    public static int idActual = 1;
    private int id;
    private int modelo;
    private ArrayList<Sensor> sensores = new ArrayList<Sensor>();
    private String marca;
    private double valorComercial;
    private String color;

    public Vehiculo() {
        this.setId(Vehiculo.getIdActual() - 1);
        Vehiculo.setIdActual(Vehiculo.getIdActual() + 1);
        Vehiculo.vehiculos.add(this);
    }

    public Vehiculo(int mo, String ma, double va) {
        this(mo, ma, va, "verde");
    }

    public Vehiculo(int mo, String ma, double va, String co) {
        this.modelo = mo;
        this.marca = ma;
        this.valorComercial = va;
        this.color = co;

        this.setId(Vehiculo.getIdActual() - 1);
        Vehiculo.setIdActual(Vehiculo.getIdActual() + 1);
        Vehiculo.vehiculos.add(this);
    }

    public String toString() {
        String r = "id: " + this.getId() + ", Modelo: " + this.getModelo() + ", Marca: " + this.getMarca()
                + ", Valor Comercial: " + this.getValorComercial() + ", Color: " + this.getColor();

        for (int i = 0; i < this.getSensores().size(); i++) {
            ArrayList<Sensor> sensores = this.getSensores();

            r = r + "  .  " + sensores.get(i).toString();
        }
        return r;

    }

    public static String toStringVehiculos() {
        String vehiculos = "";
        for (int i = 0; i < Vehiculo.cantidadVehiculos(); i++) {
            vehiculos = vehiculos + Vehiculo.vehiculos.get(i).toString() + ". ";
        }
        return vehiculos;
    }

    public static Vehiculo obtenerVehiculoPorId(int id) {
        int pos = -1;
        int i = 0;
        while (i < vehiculos.size()) {
            if (id == vehiculos.get(i).getId()) {
                pos = i;
                break;
            }
            i++;
        }

        return Vehiculo.vehiculos.get(pos);
    }

    public static int cantidadVehiculos() {
        return Vehiculo.vehiculos.size();
    }

    public int cantidadSensores() {
        return this.sensores.size();
    }

    public void anadirSensor(Sensor s) {
        this.sensores.add(s);
    }

    public int getModelo() {
        return this.modelo;
    }

    public void setModelo(int mo) {
        this.modelo = mo;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String ma) {
        this.marca = ma;
    }

    public double getValorComercial() {
        return this.valorComercial;
    }

    public void setValorComercial(double va) {
        this.valorComercial = va;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String co) {
        this.color = co;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getIdActual() {
        return Vehiculo.idActual;
    }

    public static void setIdActual(int idActual) {
        Vehiculo.idActual = idActual;
    }

    public ArrayList<Sensor> getSensores() {
        return this.sensores;
    }

    public void setSensores(ArrayList<Sensor> sensores) {
        this.sensores = sensores;
    }
}
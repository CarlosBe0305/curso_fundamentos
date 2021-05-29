package Parte_1;

public class Sensor {

    private String tipo;
    private double valor;
    private Vehiculo vehiculo;

    public Sensor() {
    }

    public Sensor(String t, double v) {
        this.tipo = t;
        this.valor = v;
    }

    public String toString() {
        return "Tipo: " + this.getTipo() + ", Valor: " + this.getValor();
    }

    public String getTipo() {
        return this.tipo;
    }

    public double getValor() {
        return this.valor;
    }

    public void setTipo(String t) {
        this.tipo = t;
    }

    public void setValor(double v) {
        this.valor = v;
    }
}
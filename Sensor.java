import java.util.ArrayList;

public class Sensor {
    public static Sensor[] sensores = new Sensor[8];
    public static int tamano = 8;
    public static int posAnadir = 0;
    private String tipo;
    private double valor;

    public Sensor() {
    }

    public Sensor(String t, double v) {
        this.tipo = t;
        this.valor = v;

        Sensor.sensores[posAnadir] = this;
        Sensor.posAnadir++;
    }

    public String toString() {
        return "Tipo: " + this.getTipo() + ", Valor: " + this.getValor();
    }

    public static String toStringSensores() {
        String sensores = "";
        for (int i = 0; i < Sensor.cantidadSensores(); i++) {
            sensores = sensores + Sensor.sensores[i].toString() + ". ";
        }
        return sensores;
    }

    public static int cantidadSensores() {
        return Sensor.posAnadir;
    }

    public static ArrayList<Sensor> TemperaturaOrden() {
        ArrayList<Sensor> tempOrden = new ArrayList<Sensor>();

        for (int i = 0; i < Sensor.cantidadSensores(); i++) {
            if (Sensor.sensores[i].getTipo().equals("temperatura")) {
                tempOrden.add(sensores[i]);
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

    public static int getTamano() {
        return Sensor.tamano;
    }

    public static int getposAnadir() {
        return Sensor.posAnadir;
    }

    public static void setTamano(int t) {
        Sensor.tamano = t;
    }

    public static void setAnadir(int a) {
        Sensor.posAnadir = a;
    }
}
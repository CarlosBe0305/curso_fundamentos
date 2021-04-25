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

        sensores[posAnadir] = this;
        posAnadir++;
    }

    public String toString() {
        return "Tipo: " + this.getTipo() + ", Valor: " + this.getValor();
    }

    public static String toStringSensores() {
        String Sensores = "";
        for (int i = 0; i < Sensor.cantidadSensores(); i++) {
            Sensores = Sensores + sensores[i].toString() + ". ";
        }
        return Sensores;
    }

    public static int cantidadSensores() {
        return posAnadir;
    }

    public static ArrayList<Sensor> TemperaturaOrden() {
        ArrayList<Sensor> TempOrden = new ArrayList<Sensor>();

        for (int i = 0; i < Sensor.cantidadSensores(); i++) {
            if (Sensor.sensores[i].getTipo().equals("temperatura")) {
                TempOrden.add(sensores[i]);
            }
        }
        for (int i = 0; i < TempOrden.size() - 1; i++) {
            int pos_menor = i;
            for (int j = i + 1; j < TempOrden.size(); j++) {
                if (TempOrden.get(j).getValor() < TempOrden.get(pos_menor).getValor()) {
                    pos_menor = j;
                }
            }
            Sensor temp = TempOrden.get(i);
            TempOrden.set(i, TempOrden.get(pos_menor));
            TempOrden.set(pos_menor, temp);
        }
        return TempOrden;
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

    public int getTamano() {
        return tamano;
    }

    public int getposAnadir() {
        return posAnadir;
    }

    public void setTamano(int t) {
        Sensor.tamano = t;
    }

    public void setAnadir(int a) {
        Sensor.posAnadir = a;
    }
}
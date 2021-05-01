public class Vehiculo {
    public static Vehiculo[] vehiculos = new Vehiculo[10];
    public static int tamano = 10;
    public static int posAnadir = 0;
    private int modelo;
    private String marca;
    private double valorComercial;
    private String color;

    public Vehiculo() {

    }

    public Vehiculo(int mo, String ma, double va) {
        this(mo, ma, va, "verde");
    }

    public Vehiculo(int mo, String ma, double va, String co) {
        this.modelo = mo;
        this.marca = ma;
        this.valorComercial = va;
        this.color = co;

        Vehiculo.vehiculos[posAnadir] = this;
        Vehiculo.posAnadir++;
    }

    public String toString() {
        return "Modelo: "+this.getModelo()+", Marca: "+
        this.getMarca()+", Valor Comercial: "+this.getValorComercial()+
        ", Color: "+this.getColor();
    }

    public static String toStringVehiculos() {
        String vehiculos ="";
        for (int i = 0; i < Vehiculo.cantidadVehiculos(); i++) {
            vehiculos = vehiculos + Vehiculo.vehiculos[i].toString() + ". ";
        }
        return vehiculos;
    }

    public static int cantidadVehiculos() {
        return Vehiculo.posAnadir;
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
}
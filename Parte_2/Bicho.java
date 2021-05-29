package Parte_2;

public class Bicho {
    private int salud;
    private String tipo;

    public Bicho(String tipo, int salud) {
        this.setSalud(salud);
        this.setTipo(tipo);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }
}

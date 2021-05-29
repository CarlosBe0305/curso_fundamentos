package Parte_2;

import java.util.Scanner;

public class mini_juego {
    private static Bicho[][] bichos = new Bicho[2][2];

    public static void main(String[] args) {
        int num = (int) (Math.random() * (4)) + 1;
        int lim = 0;

        for (int i = 0; i < mini_juego.bichos.length; i++) {
            if (num > 2) {
                for (int j = 0; j < mini_juego.bichos.length; j++) {

                    if (lim < num) {
                        int numBicho = (int) (Math.random() * (2)) + 1;

                        if (numBicho == 1) {
                            mini_juego.bichos[i][j] = new BichoNormal();
                        } else {
                            mini_juego.bichos[i][j] = new BichoAlien();
                        }
                        lim++;
                    } else {
                        break;
                    }
                }
            } else {
                if (lim < num) {
                    int numBicho = (int) (Math.random() * (2)) + 1;

                    if (numBicho == 1) {
                        mini_juego.bichos[0][i] = new BichoNormal();
                    } else {
                        mini_juego.bichos[0][i] = new BichoAlien();
                    }
                    lim++;
                } else {
                    break;
                }
            }

        }
        mini_juego.mostrarMenu();

    }

    public static void mostrarTabla() {

        System.out.println("-----------------");
        for (int i = 0; i < mini_juego.bichos.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < mini_juego.bichos.length; j++) {
                try {
                    System.out.print(
                            mini_juego.bichos[i][j].getTipo() + "-" + mini_juego.bichos[i][j].getSalud() + " | ");
                } catch (NullPointerException e) {
                    System.out.print("     " + " | ");
                }

            }
            System.out.println();
            System.out.println("-----------------");
        }
    }

    public static void mostrarMenu() {
        mini_juego.mostrarTabla();
        Scanner scan = new Scanner(System.in);

        System.out.println(
                "Escribe cualquiera de estas 3 opciones (recuerda digitar exactamente como aparece a continuación)");
        System.out.println();
        System.out.println("- disparar");
        System.out.println("- bomba-atomica");
        System.out.println("- bicho-mutante");

        String text = scan.next();
        while (true) {

            switch (text) {
                case "disparar":
                    System.out.println("Ingrese fila y después columna en donde quiere disparar");
                    mini_juego.disparar(scan.nextInt(), scan.nextInt());
                    break;
                case "bomba-atomica":
                    mini_juego.bomba();
                    break;
                case "bicho-mutante":
                    mini_juego.bichoMutante();
                    break;
                default:
                    System.out.println("No entendí que quieres hacer...");
            }

            mini_juego.mostrarTabla();

            int cont = 0;
            try {
                for (int i = 0; i < mini_juego.bichos.length; i++) {
                    for (int j = 0; j < mini_juego.bichos.length; j++) {
                        cont += mini_juego.bichos[i][j].getSalud();
                    }
                }
            } catch (NullPointerException e) {
                // TODO: handle exception
            }

            if (cont == 0) {
                System.out.println("Game Over");
                break;
            }
            System.out.println(
                    "Escribe cualquiera de estas 3 opciones (recuerda digitar exactamente como aparece a continuación)");
            System.out.println();
            System.out.println("- disparar");
            System.out.println("- bomba-atomica");
            System.out.println("- bicho-mutante");

            text = scan.next();
        }
    }

    public static void disparar(int x, int y) {
        try {
            mini_juego.bichos[x][y].setSalud(mini_juego.bichos[x][y].getSalud() - 5);
        } catch (NullPointerException e) {
            System.out.println("Hey, ¿qué pasa con tu puntería?");
        }
    }

    public static void bomba() {
        try {
            mini_juego.bichos[(int) (Math.random() * (2))][(int) (Math.random() * (2))].setSalud(0);
        } catch (NullPointerException e) {
            System.out.println("No hay bichos en la posición generada aleatoriamente");
        }
    }

    public static void bichoMutante() {
        int tempx = 0;
        int tempy = 0;

        while (mini_juego.bichos[tempx][tempy].getSalud() == 0) {
            tempy = (int) (Math.random() * (2));
            tempx = (int) (Math.random() * (2));
        }
        try {
            for (int i = 0; i < mini_juego.bichos.length; i++) {
                for (int j = 0; j < mini_juego.bichos.length; j++) {
                    if ((mini_juego.bichos[i][j].getSalud() < mini_juego.bichos[tempx][tempy].getSalud())
                            && (mini_juego.bichos[i][j].getSalud() > 0)) {
                        tempx = i;
                        tempy = j;
                    }
                }
            }
        } catch (NullPointerException e) {
            // TODO: handle exception
        }

        mini_juego.bichos[tempx][tempy].setSalud(mini_juego.bichos[tempx][tempy].getSalud() * 2);
    }
}
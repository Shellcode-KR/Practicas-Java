package simuladordeprocesos;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*
    0.Tiempo
    1.CREAR PROCESOS
    2. si tiempo de llegada igual a tiempo proceso[] cambia a estado listo, proceso x se muestra
    3.Hacer una cola de procesos
 */
public class Simuladordeprocesos {

    static int[] tiempo = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};

    static Proceso p1 = new Proceso("#01", 0, 6, 3, 3, 31, 31);
    static Proceso p2 = new Proceso("#02", 2, 3, 31, 31, 31, 31);
    static Proceso p3 = new Proceso("#03", 8, 4, 31, 31, 10, 31);
    static Proceso p4 = new Proceso("#04", 13, 6, 31, 31, 31, 15);

    static Proceso[] cprocesos = new Proceso[]{p1, p2, p3, p4};

    public static void main(String[] args) {

        System.out.println("");
        estadoprocesos();

        for (int i = 0; i < tiempo.length; i++) {

            System.out.println("TIEMPO " + tiempo[i] + " : ");

            //bucle para ejecutar
            for (Proceso pr : cprocesos) {
                if (pr.gettLlegada() == tiempo[i]) {
                    pr.listo();
                }
            }

            for (Proceso pr : cprocesos) {
                if (pr.getTiBloq() == tiempo[i]) {
                    pr.espera();
                }
            }

            

            for (Proceso pr : cprocesos) {
                if (pr.getEstado().equals("listo") || pr.gettLlegada() == tiempo[i]) {
                    pr.ejecucion();
                }
            }
            
            for (Proceso pr : cprocesos) {
                if (pr.getTiListo() == tiempo[i]) {
                    pr.listo();
                    pr.settLlegada(tiempo[1] + 3);
                }
            }
            for (Proceso pr : cprocesos) {
                if (pr.getEstado().equals("ejecucion")) {
                    pr.ejecutarproceso();
                }
            }

            for (Proceso pr : cprocesos) {
                if (pr.getEstado().equals("en espera")) {
                    pr.esperando();
                }
            }

            //bucle de listo
            for (Proceso pr : cprocesos) {
                if (pr.getTiES() == tiempo[i]) {
                    pr.datosES();
                    Scanner sc = new Scanner(System.in);
                    sc.nextLine();
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Error");
            }
        }
        estadoprocesos();
    }

    public static void estadoprocesos() {

        for (Proceso i : cprocesos) {
            System.out.println(i);
        }

    }
}

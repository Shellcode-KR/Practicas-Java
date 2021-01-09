package simuladordeprocesos;

/**
 *
 * @author Flavio
 */
public class Proceso {

    private final String id;
    private boolean nuevo, listo, ejecucion, espera, terminado;
    private int tLlegada;

    public void settLlegada(int tLlegada) {
        this.tLlegada = tLlegada;
    }
    private int tCPU, tiBloq, tBloq,tiES,tiListo;

    public int getTiES() {
        return tiES;
    }

    public Proceso(String id2, int tLlegada2, int tCPU2, int tiBloq2, int tBloq2,int tiEs,int tiListo2) {
        id = id2;
        tLlegada = tLlegada2;
        tCPU = tCPU2;
        tiBloq = tiBloq2;
        tBloq = tBloq2;
        nuevo = true;
        tiES = tiEs;
        tiListo = tiListo2;
    }

    public int getTiListo() {
        return tiListo;
    }

    public void listo() {
        nuevo = false;
        listo = true;
        ejecucion = false;
        espera = false;
        terminado = false;
        System.out.println("\tProceso "+id+" LISTO");

    }

    public void ejecucion() {
        nuevo = false;
        listo = false;
        ejecucion = true;
        espera = false;
        terminado = false;
    System.out.println("\tProceso "+id+" en ejecucion");
    }

    public void espera() {
        nuevo = false;
        listo = false;
        ejecucion = false;
        espera = true;
        terminado = false;
        System.out.println("\tProceso "+id+" en espera");
    }

    public void terminado() {
        nuevo = false;
        listo = false;
        ejecucion = false;
        espera = false;
        terminado = true;
        System.out.println("\tProceso "+id+" Terminado");
    }

    public String getEstado() {
        String estado="";
        if (nuevo == true) {
            estado = "nuevo";
        }
        if (listo == true) {
            estado = "listo";
        }
        if (ejecucion == true) {
            estado = "ejecucion";
        }
        if (espera == true) {
            estado = "en espera";
        }
        if (terminado == true) {
            estado = "terminado";
        }
        return (estado);
    }

    @Override
    public String toString() {
        String estado="";
        if (nuevo == true) {
            estado = "nuevo";
        }
        if (listo == true) {
            estado = "listo";
        }
        if (ejecucion == true) {
            estado = "ejecucion";
        }
        if (espera == true) {
            estado = "en espera";
        }
        if (terminado == true) {
            estado = "terminado";
        }
        return ("Proceso "+id+" "+estado);
    }


    public int gettLlegada() {
        return tLlegada;
    }

    public int gettCPU() {
        return tCPU;
    }

    public int getTiBloq() {
        return tiBloq;
    }

    public int gettBloq() {
        return tBloq;
    }
    public void ejecutarproceso(){
        if(tCPU>0){
            tCPU--;
            System.out.println("\ttiempo ejecucion "+id+": "+tCPU);
            
            if(tCPU<1){
                terminado();
            }
        }    }
    public void esperando(){
        if(tBloq>0){
            tBloq--;
            System.out.println("\ttiempo espera "+id+": "+tBloq);
            
            if(tBloq<1){
                listo();
            }
        }
    }
    public void datosES(){
        
        System.out.println("Pidiendo datos al usuario");
    }
}

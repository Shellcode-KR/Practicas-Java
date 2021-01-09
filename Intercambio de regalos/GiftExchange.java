 /**
 * Programa simular un intercambio de regalos
 *  ++intercambio de regalos++
 *  
 *  1.	El usuario debe elegir cuantos partisipantes va a haber
 *  2.	EN orden los partisipantes saldran y eligiran a quien le va a regalar
 *  3. 	con un numero aleatorio entre los partisipantes se elegira 
 *  4.	cuando salga un numero se borrara con -1
 *  5.	las condiciones son
 *  	a.	que no sea el mismo
 *  	b. 	que no haya pasado
 *  	
 */

/**
 * @author FLAViO
 *
 */

import java.util.InputMismatchException;
import java.util.Scanner;
public class GiftExchange {
	
	public int participantes;
	public int[] lista;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GiftExchange ge = new GiftExchange();
		ge.pedirDatos();
		ge.crearPartisipantes();
		ge.interegalos();

	}
	public void pedirDatos() {
		boolean numero=false;
		
		while (numero==false) {
			Scanner sc = new Scanner(System.in);
			System.out.println("¿Cuantos participantes tendra el intercambio?");
			try {
				participantes = sc.nextInt();
				numero=true;
				if(participantes<=1) {
					System.err.print("elija un numero valido; >0");
					numero=false;
				}
				
			} catch (InputMismatchException e) {
				System.err.println("Solo se aceptan numeros");
			}
			
			System.out.println("");
			sc.close();
			
			
		}
		
		
	}
	public void crearPartisipantes() {
		lista = new int[participantes];
		for (int i = 0; i < lista.length; i++) {
			lista[i] =(i+1);
			
		}
	}
	public void interegalos() {
		int r2=0;
		for (int i = 0; i < lista.length; i++) {
		
			System.out.println("El participante "+(i+1)+" le dara regalo a el participante ");
			{
				boolean correcto=false;
				while(correcto==false) {
					int receptor= destinatario();
					
					if(receptor!=i) {
						
						if(lista[receptor]!=-1) {
							r2= lista[receptor];
							lista[receptor]=-1;
							correcto=true;
							
						}
						
					}
					
					
				}
			}
			System.out.println(r2);
		}
	}
	public int destinatario() {
		int aleatorio =(int)(Math.random()*(participantes));
		return aleatorio;
	}

}

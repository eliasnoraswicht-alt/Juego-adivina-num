package juego;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in); 
	int opcion = 0;
	
	//estructura de control usamos el while para mantener el menu prendido
	do {
		System.out.println("\n===========================");
		System.out.println("  JUEGO DE ADIVINAR EL NUMERO   ");
		System.out.println("===============================");
		System.out.println("1. Jugar nueva partida");
		System.out.println("2. Salir");
		System.out.println("Elige una opcion");
		
		//validacion entrada numerica
		
		if (scanner.hasNextInt()) {
			opcion = scanner.nextInt();
		} else {
			System.out.println("Error: Porfavor introduzca un numero valido.");
			scanner.next(); //limpiar buffer del scanner
			continue; 
		}
		
		//estructura  de control (swicht)
		 
		switch (opcion) {
			case 1:
				iniciarpartida(scanner);
				break;
			case 2:
				System.out.println("Gracias por jugar! Saliendo de la Aplicacion...");
				break;
				default:
					System.out.println("Opcion invalida. Por favor, Elige 1 o 2..");
	           }
	} while (opcion != 2);	
	 
         scanner.close();
	}
	
	
	private static void iniciarpartida(Scanner scanner) {
		int maxintentos = 5;
		int rangomax = 50;
		
		
		// creacion del objeto apartir de la clase adivinanumero
		Adivinanumero juego = new Adivinanumero(maxintentos, rangomax);
		
		System.out.println("n--- Nueva partida iniciada ---");
		System.out.println("he pensado un numero entre 1 y " + rangomax + "."); 
		System.out.println("tienes "+ maxintentos + "intentos para adivinarlo");
		
		//estructura del while
		while (juego.tieneintentos() && !juego.isganado()) {
			System.out.println("ingresa tu numero");
			
			if (scanner.hasNextInt()) {
				int intentousuario = scanner.nextInt();
				
				//llamada  de metodo y obtencion de la respuesta
				String pista = juego.evaluarIntento(intentousuario);
				System.out.print(pista);
				
				//demostracion del ciclo for para que se pueda mostrar el historial
				juego.mostrarhistorial();
				System.out.println("----------------------------");
			} else {
				System.out.println("Por favor, ingrese un numero entero valido.");
				scanner.next(); //limpiar buffer
			}
		}
		
		// estructura de control if/ else para el cierre de la partida
		if(juego.isganado()) {
			System.out.println("!Felicidades, superaste el desafio");
		} else {
			
			System.out.println("Te has quedado sin intentos! El numero secreto era: " + juego.getnumerosecreto());
	       }
	}
}
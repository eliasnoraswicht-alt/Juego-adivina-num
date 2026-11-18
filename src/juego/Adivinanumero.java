package juego;


import java.util.Random;

public class Adivinanumero {

	// Atributos de la clase
	private int numerosecreto;
	private int intentosrestantes;
	private int maxintentos;
	private boolean ganado; 
	private int[] historialintentos;
	private int indicehistorial;

	//constructor 
	public Adivinanumero(int maxintentos, int rangomax) {
		this.maxintentos = maxintentos;
		this.intentosrestantes = maxintentos; 
		this.ganado = false;
		this.historialintentos = new int[maxintentos]; 
		this.indicehistorial = 0;
		
		// generar numero aleatorio entre 1 y rangomax
		Random random = new Random(); 
		this.numerosecreto = random.nextInt(rangomax) + 1; 
	}
	
	// Metodo para evaluar al usuario
	public String evaluarIntento(int intento) {
		historialintentos[indicehistorial] = intento;
		indicehistorial++;
		intentosrestantes--;
		
		if (intento == numerosecreto) {
			ganado = true;
			return "!Felicitaciones, Has adivinado el numero secreto!";
		} else if (intento < numerosecreto) {
			return "Demasiado bajo, te quedan " + intentosrestantes + "intentos"; 
		} else {
			return "Demasiado alto, te quedan " + intentosrestantes + "intentos"; 
		    }
	    
	      
	}
	
	//metodo getters y de estado
	public boolean isganado() {
		return ganado;
	}
	
	public boolean tieneintentos() {
	return intentosrestantes > 0; 
	}
	
	public int getnumerosecreto() {
		return numerosecreto;
	}
	public int getmaxintentos() {
		return maxintentos;
	}
	
	//metodo que se usa para poder ver el historial
	public void mostrarhistorial() {
		System.out.print("tus intentos anteriores fueron: ");
		for (int i = 0; i < indicehistorial; i++)  {
			System.out.print(historialintentos[i] + " "); 
		}
		System.out.println();
	
			
		}
	
	
	
	

	
	
		
		
	}
	
	
	

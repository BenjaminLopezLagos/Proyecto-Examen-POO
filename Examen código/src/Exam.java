import java.util.ArrayList;
import java.util.Scanner;
/**
 * Esta clase se encargar� que generar un examen que contendr� cualquiera de los 3 tipos de Preguntas y de llevar un contador de los puntos que obtiene el usuario.
 * @author Benjam�n L�pez Lagos
 *
 */
public class Exam {
	private ArrayList<Pregunta> preguntas; //Arreglo que contiene objetos tipo Pregunta
	static int puntos = 0; //Puntos que ha obtenido el usuario hasta el momento
	static int puntajetotalExam = 0; // puntaje total de todo el examen
	private int cantidadPreguntas = 10; //indicador del l�mite de preguntas
	
	public int getCantidadPreguntas() {
		return cantidadPreguntas;
	}

	/**
	 * Constructor por defecto de la clase Exam. Se crea un arrayList de objetos Pregunta de l�mite cantidadPreguntas.
	 */
	public Exam() {
		this.preguntas = new ArrayList<Pregunta>(cantidadPreguntas);	
	}
	
	/**
	 * M�todo que agrega un objeto Pregunta al arrayList. Primero comprueba si el tama�o que tiene el arreglo hasta el momento es menor a la cantidad de preguntas. Si se cumple, se agrega al array.
	 * @param pregunta Puede ser TFpregunta, Selec_Mult_Preguntas o Resp_Cortas_Pregunta.
	 */
	public void agregaPregunta(Pregunta pregunta) {
		if(preguntas.size()<cantidadPreguntas) {
			preguntas.add(pregunta);
		}
	}
	
	/**
	 * M�todo que muestra el contenido de una posici�n del arreglo preguntas. Tambi�n se encarga de tomar la respuesta dada por el usuario y ejecutar el m�todo buscar, junto con la posibilidad de cerrar el programa si se te acaban los intentos.
	 * @param pregunta Puede ser TFpregunta, Selec_Mult_Preguntas o Resp_Cortas_Pregunta.
	 */
	public void displayPregunta(Pregunta pregunta) {
		pregunta.display();
		do {
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			String respuestaUsuario = in.nextLine();
			pregunta.buscar(respuestaUsuario);
			if(pregunta.getCantidadDeIntentos() == 0) {
				System.out.println("\nVaya a estudiar! ");
				System.exit(0);
			}
		}while(!pregunta.getRespuestaValida());	
	}
	
	/**
	 * M�todo que inicia el examen para el usuario. Recorre el array de preguntas y ejecuta displayPregunta. Al final, muestra el puntaje obtenido y ejecuta dos m�todos para mostrar el puntaje total del examen, porcentaje obtenido y una lista de resumen.
	 */
	public void darExam() {
		for(Pregunta p:preguntas) {
			try {
			displayPregunta(p);
			}catch(Exception e) {
				System.out.println("\nPregunta inv�lida! Aseg�rese de que ciertos par�metros como el tama�o del array correspondiente a las respuestasPosibles sea menor o igual al de alternativas. ");
				puntajetotalExam -= p.getPeso();
			}
		}
		System.out.println("\npuntos del usuario "+puntos);
		this.puntosTotalExam();
		this.ListaBuenasMalas();
		pressAnyKeyToContinue();
	}
	
	/**
	 * Este m�todo muestra los puntos totales de un examen y saca un porcentaje cumplido por el usuario basado en sus puntos.
	 */
	public void puntosTotalExam() {
		for(Pregunta p:preguntas) {
			puntajetotalExam += p.getPeso();
		}
		System.out.println("\npuntaje total: "+puntajetotalExam);
		if(puntajetotalExam != 0) {
			System.out.println("\n% obtenido: "+(puntos*100/puntajetotalExam)+"%\n");
		}else {
			System.out.println("\n% obtenido: 0%\n");
		}
	}
	
	/**
	 * Este m�todo genera una lista resumiendo las preguntas que fueron respondidas correctamente. Se basa los valores boolean que retorna buscar().
	 */
	public void ListaBuenasMalas() {
		int i = 1;
		System.out.println("Resumen respuestas correctas e incorrectas\n------------------------------------");
		for(Pregunta p:preguntas) {
			if(p.getCorrectOrIncorrect()) {
				System.out.println("\nPregunta "+i+") "+p.getTexto()+". puntos: "+p.getPeso()+". correcta.");
			}else {
				System.out.println("\nPregunta "+i+") "+p.getTexto()+". puntos: "+p.getPeso()+". incorrecta.");
			}
			i++;
		}	
	}
	
	 private void pressAnyKeyToContinue(){ 
	        System.out.println("Pulsa Enter para finalizar");
	        try{
	            System.in.read();
	        }  
	        catch(Exception e){}  
	 }
}

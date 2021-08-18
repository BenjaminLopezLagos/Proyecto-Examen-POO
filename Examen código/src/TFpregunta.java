/**
 * Subclase de Pregunta que representan las preguntas de verdadero o falso.
 * @author Benjamín López Lagos
 *
 */
public class TFpregunta extends Pregunta {
	private boolean respuestaTF;
	
	public boolean getRespuestaTF() {
		return this.respuestaTF;
	}

	public void setRespuestaTF(boolean respuestaTFcorrecta) {
		this.respuestaTF = respuestaTFcorrecta;
	}
	
	/**
	 * Constructor de TFpregunta.
	 * @param peso puntos
	 * @param texto enunciado
	 * @param respuestaTF exclusiva de esta clase. Corresponde a la respuesta correcta de la pregunta.
	 */
	public TFpregunta(int peso, String texto, boolean respuestaTFcorrecta) {
		super(peso,texto);
		this.respuestaTF = respuestaTFcorrecta;
	}
	
	public void display() {
		System.out.println("\nVerdadero o Falso => Responder con T o F respectivamente.");
		super.display();
	}

	@Override
	public boolean buscar(String respuestaUsuario) {
			switch(respuestaUsuario.toUpperCase()) {
			case "T":
				if(respuestaTF) {
					System.out.println("correcta!");
					Exam.puntos += this.getPeso();
					respuestaValida = true;
					correctOrIncorrect = true;
				}else {
					System.out.println("incorrecta!");
					respuestaValida = true;
					correctOrIncorrect = false;
				}
			break;
						
			case "F":
				if(!respuestaTF) {
					System.out.println("correcta!");
					Exam.puntos += this.getPeso();
					respuestaValida = true;
					correctOrIncorrect = true;
				}else {
					System.out.println("incorrecta!");
					respuestaValida = true;
					correctOrIncorrect = false;
				}
				break;
						
			default:
				System.out.println("respuesta no válida! te quedan "+(cantidadDeIntentos-1)+" intentos");
				respuestaValida = false;
				cantidadDeIntentos--;
				break;
			}
		return 	correctOrIncorrect;
	}


		
}



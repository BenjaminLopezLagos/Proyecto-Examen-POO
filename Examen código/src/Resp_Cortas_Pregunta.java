/**
 * Esta subclase de Pregunta consiste en un tipo de preguntas que se pueden responder con palabras u oraciones.
 * @author Benjamín López Lagos
 *
 */
public class Resp_Cortas_Pregunta extends Pregunta{
	private String respuestaRC; // Representa la respuesta correcta de una pregunta.

	public String getRespuestaRC() {
		return this.respuestaRC;
	}

	public void setRespuestaRC(String respuestaRCcorrecta) {
		this.respuestaRC = respuestaRCcorrecta;
	}
	
/**
 * Constructor de preguntas de respuestas cortas.
 * @param peso variable heredada de clase abstracta Pregunta.
 * @param texto variable heredada de clase abstracta Pregunta.
 * @param respuestaRC Representa la respuesta correcta de una pregunta.
 */
	public Resp_Cortas_Pregunta(int peso, String texto,String respuestaRC) {
		super(peso,texto);
		this.respuestaRC = respuestaRC;	
	}

	public void display() {
		System.out.println("\nPreguntas de respuestas cortas => responder con palabra u oración.");
		super.display();
	}

	@Override
	public boolean buscar(String respuestaUsuario) {
		if(respuestaUsuario.equalsIgnoreCase(this.respuestaRC)) {
			System.out.println("correcta!");
			Exam.puntos += this.getPeso();
			respuestaValida = true;
			correctOrIncorrect = true;
		}else {
			System.out.println("incorrecta!");
			respuestaValida = true;
			correctOrIncorrect = false;
		}
		return correctOrIncorrect;
	}
	
}

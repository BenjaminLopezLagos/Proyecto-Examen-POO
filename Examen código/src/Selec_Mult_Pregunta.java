/**
 * Subclase de Pregunta que representan las preguntas de selección múltiple.
 * @author Benjamín López Lagos
 *
 */
public class Selec_Mult_Pregunta extends Pregunta{
	private String[] respuestasPosibles;
	private String[] alternativas = {"a","b","c","d","e","f"};
	private int respuestaSM;
	
	/**
	 * getter de la respuesta.
	 * @return respuestaSM
	 */
	public int getRespuestaSM() {
		return this.respuestaSM;
	}

	/**
	 * getter de respuestasPosibles.
	 * @return respuestasPosibles
	 */
	public String[] getRespuestasPosibles() {
		return this.respuestasPosibles;
	}
	
	/**
	 * getter de alternativas
	 * @return alternativas
	 */
	public String[] getAlternativas() {
		return this.alternativas;
	}
	
	/**
	 * Constructor de preguntas de selección múltiple.
	 * @param peso puntos
	 * @param texto enunciado
	 * @param respuestasPosibles arreglo de strings que puede ser dado como parámetro por el usuario.
	 * @param respuestaSM posición del array representando la respuesta correcta.
	 */
	public Selec_Mult_Pregunta(int peso, String texto,String[] respuestasPosibles,int respuestaSM) {
		super(peso,texto);
		this.respuestasPosibles = respuestasPosibles;
		this.respuestaSM = respuestaSM;
	}
	
	public void display() {
		System.out.println("\nSelección múltiple => Responder solo con las letras que se muestran a continuación.");
		super.display();
		for(int i = 0; i < respuestasPosibles.length; i++) {
			System.out.println(alternativas[i]+". "+respuestasPosibles[i]);
		}
	}

	@Override
	public boolean buscar(String respuestaUsuario) {
		int punteroRespuesta = 0;
		for(int i = 0; i < respuestasPosibles.length; i++) {
			if(respuestaUsuario.equalsIgnoreCase(alternativas[i])) {
				punteroRespuesta = i;
				break;
			}
			punteroRespuesta = 100;//o algún valor que sea mayor al límite de alternativas
		}

		if(punteroRespuesta > alternativas.length && punteroRespuesta > respuestasPosibles.length) {
			respuestaValida = false;
		}else {
			respuestaValida = true;
		}
		
		if(respuestaValida) {
			if(respuestasPosibles[respuestaSM].equalsIgnoreCase(respuestasPosibles[punteroRespuesta])) {
				System.out.println("correcta!");
				Exam.puntos += this.getPeso();
				this.correctOrIncorrect = true;
			}else {
				System.out.println("incorrecta!");
				this.correctOrIncorrect = false;
			}
		}else {
			System.out.println("respuesta no válida! te quedan "+(cantidadDeIntentos-1)+" intentos");
			respuestaValida = false;
			cantidadDeIntentos--;
		}
		
		return this.correctOrIncorrect;
		

	}

}

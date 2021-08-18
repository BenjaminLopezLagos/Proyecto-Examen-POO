/**
 * Subclase de Pregunta que representan las preguntas de selecci�n m�ltiple.
 * @author Benjam�n L�pez Lagos
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
	 * Constructor de preguntas de selecci�n m�ltiple.
	 * @param peso puntos
	 * @param texto enunciado
	 * @param respuestasPosibles arreglo de strings que puede ser dado como par�metro por el usuario.
	 * @param respuestaSM posici�n del array representando la respuesta correcta.
	 */
	public Selec_Mult_Pregunta(int peso, String texto,String[] respuestasPosibles,int respuestaSM) {
		super(peso,texto);
		this.respuestasPosibles = respuestasPosibles;
		this.respuestaSM = respuestaSM;
	}
	
	public void display() {
		System.out.println("\nSelecci�n m�ltiple => Responder solo con las letras que se muestran a continuaci�n.");
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
			punteroRespuesta = 100;//o alg�n valor que sea mayor al l�mite de alternativas
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
			System.out.println("respuesta no v�lida! te quedan "+(cantidadDeIntentos-1)+" intentos");
			respuestaValida = false;
			cantidadDeIntentos--;
		}
		
		return this.correctOrIncorrect;
		

	}

}

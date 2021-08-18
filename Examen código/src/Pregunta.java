/**
 * Esta clase abstracta servirá como una estructura predefinida para otro tipo de preguntas
 * @author Benjamín López Lagos
 *
 */
public abstract class Pregunta 
{
	
	private int peso; //Los puntos de una pregunta
	private String texto; //Enunciado
	protected boolean respuestaValida; //Comprueba si la respuesta del usuario es válida o inválida
	protected boolean correctOrIncorrect; //Comprueba si la respuesta del usuario es correcta (true) o incorrecta (false)
	protected int cantidadDeIntentos = 3; //Cantidad de intentos que tiene cada pregunta en caso de que la respuesta sea inválida
	
	/**
	 * Constructor por defecto de Pregunta
	 */
	public Pregunta() 
	{
		this.peso = 0;
		this.texto = "sin pregunta";
	}
	/**
	 * Constructor de Pregunta.
	 * @param peso Corresponde a los puntos que tendrá una pregunta
	 * @param texto Corresponde al enunciado que tendrá la pregunta
	 */
	public Pregunta(int peso, String texto) 
	{
		this.peso = peso;
		this.texto = texto;
	}

	public int getPeso() 
	{
		return this.peso;
	}

	public void setPeso(int peso) 
	{
		this.peso = peso;
	}

	public String getTexto() 
	{
		return this.texto;
	}

	public void setTexto(String texto) 
	{
		this.texto = texto;
	}
	/**
	 * display() es el método que se encarga de imprimir en pantalla tanto el enunciado, como los puntos correspondientes a la pregunta. 
	 */
	public void display() 
	{
		System.out.println("\nPREGUNTA "+this.getTexto());
		System.out.println("puntaje "+this.getPeso());
	}	
	
	public boolean getRespuestaValida() 
	{
		return respuestaValida;
	}
	
	public boolean getCorrectOrIncorrect() 
	{
		return correctOrIncorrect;
	}
	
	public void setRespuestaValida(boolean respuestaValida) 
	{
		this.respuestaValida = respuestaValida;
	}
	
	public int getCantidadDeIntentos() 
	{
		return cantidadDeIntentos;
	}
	
	/**
	 * 
	 * @param respuestaUsuario es la respuesta que dará el usuario a partir de cada pregunta
	 * @return retornará valores booleanos para demostrar si la respuesta del usuario es correcta o incorrecta
	 */
	public abstract boolean buscar(String respuestaUsuario);

 
}

/**
 * Clase testeadora y principal del proyecto.
 * @author Benjamín López Lagos
 *
 */
public class ExamDemo {
	/**
	 * Creamos un objeto Exam y vamos ejecutando instancias para agregar preguntas al examen.
	 */
	public static void main(String[] args) {
	    Exam miExam = new Exam();
	    
	    System.out.println("\nEste es un examen que contiene "+miExam.getCantidadPreguntas()+" preguntas.");
	    
	    String santiagoElec[] = {"Santiago", "Valparaiso", "Concepcion", "Magallanes"}; 
	    String BCElec[] = {"Vancouver","Victoria", "Nanaimo"};
	    String PElec[] = {"Rio de Janeiro", "Sao Paulo", "Blumenau","Brasilia"}; 
	    String COelec[]= {"not caracas","Lima","Caracas","Ciudad de Perú","Malos Aires","Venezuela 2"};
	    
	    miExam.agregaPregunta(new TFpregunta(1,"La capital de Chile es Santiago", true)); //1
	    miExam.agregaPregunta(new Selec_Mult_Pregunta(1,"Cuál es la capital de Region Metropolitana", santiagoElec, 0)); //2
	    miExam.agregaPregunta(new Resp_Cortas_Pregunta(1,"Cuál es la capital de IV Region", "Coquimbo")); //3
	    miExam.agregaPregunta(new TFpregunta(1,"La capital de Alberta es Calgary", false)); //4
	    miExam.agregaPregunta(new Selec_Mult_Pregunta(2,"Cuál es la capital de British Columbia", BCElec, 1)); //5
	    miExam.agregaPregunta(new TFpregunta(1,"La capital de La Serena es Illapel", false)); //6
	    miExam.agregaPregunta(new Selec_Mult_Pregunta(2,"Cuál es la capital de Brasil?", PElec, 3)); //7
	    miExam.agregaPregunta(new TFpregunta(1,"mp3 es un formato de video", false)); //8
	    miExam.agregaPregunta(new Selec_Mult_Pregunta(2,"Cuál es la capital de Venezuela?", COelec, 2)); //9
	    miExam.agregaPregunta(new Resp_Cortas_Pregunta(2,"qué significa SSD?", "Solid State Drive")); //10
	    miExam.agregaPregunta(new Resp_Cortas_Pregunta(1,"Cuál es la capital de Argentina", "Buenos Aires")); //11
	    miExam.agregaPregunta(new Resp_Cortas_Pregunta(2,"Cuál es la capital de Canada", "Ottawa")); //12
	    miExam.darExam();
	}
}

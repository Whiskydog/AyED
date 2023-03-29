package tp01.ejercicio3;

public class Solucion {

	public static void main(String[] args) {
		Persona[] personas = new Persona[] {
			new Estudiante("Pedro", "Juarez", "1A", "pjuarez@info.com", "C. 13 600"),
			new Estudiante("Juan", "Perez", "2C", "jperez@info.com", "C. 25 700"),
			new Profesor("Pablo", "Velazquez", "pvel@info.com", "AyED", "Informatica"),
			new Profesor("Jose", "Alvarado", "jalva@info.com", "ISO", "Informatica"),
			new Profesor("Ricardo", "Sanchez", "rsanz@info.com", "OO1", "Informatica")
		};
		
		for (Persona persona : personas) {
			System.out.println(persona.tusDatos());
		}
	}
}

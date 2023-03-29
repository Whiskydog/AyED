package tp02.ejercicio2;

import tp01.ejercicio3.Estudiante;
import tp01.ejercicio3.Persona;

public class TestListaEnlazadaGenerica {

	public static void main(String[] args) {
		ListaGenerica<Persona> lista = new ListaEnlazadaGenerica<>();
		lista.agregarFinal(new Estudiante("Pedro", "Juarez", "1A", "pjuarez@info.com", "C. 13 600"));
		lista.agregarFinal(new Estudiante("Juan", "Perez", "2C", "jperez@info.com", "C. 25 700"));
		lista.agregarFinal(new Estudiante("Pablo", "Velazquez", "pvel@info.com", "3B", "C. 13 2500"));
		lista.agregarFinal(new Estudiante("Jose", "Alvarado", "jalva@info.com", "4C", "C. 1 3200"));

		lista.comenzar();
		while (!lista.fin())
			System.out.println(lista.proximo().tusDatos());
	}

}

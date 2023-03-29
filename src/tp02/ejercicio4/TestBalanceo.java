package tp02.ejercicio4;

import java.util.List;

import tp02.ejercicio3.PilaGenerica;

public class TestBalanceo {

	public static void main(String[] args) {
		System.out.println(new TestBalanceo().esBalanceado(args[0]));
	}

	private final List<Character> openings = List.of('{', '[', '(');
	private final List<Character> closings = List.of('}', ']', ')');

	public boolean esBalanceado(String s) {
		if (s.isBlank())
			return true;

		PilaGenerica<Character> pila = new PilaGenerica<>();
		for (char c : s.toCharArray()) {
			if (openings.contains(c)) {
				pila.apilar(c);
			} else if (closings.contains(c)) {
				if (pila.esVacia())
					return false;

				char opening = pila.desapilar();
				if (openings.indexOf(opening) != closings.indexOf(c))
					return false;
			}
		}

		return pila.esVacia();
	}

}

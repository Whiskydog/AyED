package tp02.ejercicio1;

public class TestListaDeEnterosConArreglos {

	public static void main(String[] args) {
		ListaDeEnteros lista = new ListaDeEnterosConArreglos();

		for (String arg : args) {
			try {
				lista.agregarFinal(Integer.parseInt(arg));
			} catch (NumberFormatException e) {
				System.out.println(arg + " NaN");
			}
		}

		System.out.println(lista);
	}

}
